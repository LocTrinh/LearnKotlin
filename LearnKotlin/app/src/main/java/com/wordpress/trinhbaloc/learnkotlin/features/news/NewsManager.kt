package com.wordpress.trinhbaloc.learnkotlin.features.news

import com.wordpress.trinhbaloc.learnkotlin.api.RestAPI
import com.wordpress.trinhbaloc.learnkotlin.commons.RedditNewsItem
import rx.Observable

/**
 * News Manager allows you to request more news from Reddit.
 *
 * @author juancho
 */
class NewsManager(private val api: RestAPI = RestAPI()) {


    fun getNews(limit: String = "100"): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->

            val callResponse = api.getNews("", limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val news = response.body().data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                subscriber.onNext(news)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }

        }
    }
}