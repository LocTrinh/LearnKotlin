package com.wordpress.trinhbaloc.learnkotlin.features.news

import com.wordpress.trinhbaloc.learnkotlin.api.NewsAPI
import com.wordpress.trinhbaloc.learnkotlin.api.RedditNewsResponse
import com.wordpress.trinhbaloc.learnkotlin.commons.RedditNews
import com.wordpress.trinhbaloc.learnkotlin.commons.RedditNewsItem
import javax.inject.Inject
import javax.inject.Singleton

/**
 * News Manager allows you to request news from Reddit API.
 *
 * @author juancho
 */
@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {

    /**
     *
     * Returns Reddit News paginated by the given limit.
     *
     * @param after indicates the next page to navigate.
     * @param limit the number of news to request.
     */
    suspend fun getNews(after: String, limit: String = "10"): RedditNews {
        val result = api.getNews(after, limit)
        return process(result)
    }

    private fun process(response: RedditNewsResponse): RedditNews {
        val dataResponse = response.data
        val news = dataResponse.children.map {
            val item = it.data
            RedditNewsItem(item.author, item.title, item.num_comments,
                    item.created, item.thumbnail, item.url)
        }
        return RedditNews(
                dataResponse.after.orEmpty(),
                dataResponse.before.orEmpty(),
                news)
    }
}