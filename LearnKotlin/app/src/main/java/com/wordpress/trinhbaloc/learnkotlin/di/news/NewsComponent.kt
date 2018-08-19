package com.wordpress.trinhbaloc.learnkotlin.di.news

import com.wordpress.trinhbaloc.learnkotlin.di.AppModule
import com.wordpress.trinhbaloc.learnkotlin.di.NetworkModule
import com.wordpress.trinhbaloc.learnkotlin.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 *
 * @author juancho.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}