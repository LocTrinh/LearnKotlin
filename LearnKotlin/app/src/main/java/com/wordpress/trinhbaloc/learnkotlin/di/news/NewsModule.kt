package com.wordpress.trinhbaloc.learnkotlin.di.news

import com.wordpress.trinhbaloc.learnkotlin.api.NewsAPI
import com.wordpress.trinhbaloc.learnkotlin.api.NewsRestAPI
import com.wordpress.trinhbaloc.learnkotlin.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 *
 * @author juancho.
 */
@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI {
        return NewsRestAPI(redditApi)
    }

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi {
        return retrofit.create(RedditApi::class.java)
    }

    /**
     * NewsManager is automatically provided by Dagger as we set the @Inject annotation in the
     * constructor, so we can avoid adding a 'provider method' here.
     */
}