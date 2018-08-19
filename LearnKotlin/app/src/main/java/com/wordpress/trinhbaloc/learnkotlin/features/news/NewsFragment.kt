package com.wordpress.trinhbaloc.learnkotlin.features.news


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wordpress.trinhbaloc.learnkotlin.R
import com.wordpress.trinhbaloc.learnkotlin.commons.InfiniteScrollListener
import com.wordpress.trinhbaloc.learnkotlin.commons.RedditNews
import com.wordpress.trinhbaloc.learnkotlin.commons.RxBaseFragment
import com.wordpress.trinhbaloc.learnkotlin.commons.extensions.inflate
import com.wordpress.trinhbaloc.learnkotlin.features.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*
import rx.schedulers.Schedulers

class NewsFragment : RxBaseFragment()  {

    private var redditNews: RedditNews? = null

    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        val linearLayout = LinearLayoutManager(context)
        news_list.layoutManager = linearLayout
        news_list.clearOnScrollListeners()
        news_list.addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }

    }
    private fun requestNews() {
        /**
         * first time will send empty string for after parameter.
         * Next time we will have redditNews set with the next page to
         * navigate with the after param.
         */
        val subscription = newsManager.getNews(redditNews?.after ?: "")
                .subscribeOn(Schedulers.io())
                .subscribe (
                        { retrievedNews ->
                            //(news_list.adapter as NewsAdapter).addNews(retrievedNews)
                            redditNews = retrievedNews
                            (news_list.adapter as NewsAdapter).addNews(retrievedNews.news)

                        },
                        { e ->
                            Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                        }
                )

    }
    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}
