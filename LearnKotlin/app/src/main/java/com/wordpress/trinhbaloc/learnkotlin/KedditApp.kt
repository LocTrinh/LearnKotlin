package com.wordpress.trinhbaloc.learnkotlin

import android.app.Application
import com.wordpress.trinhbaloc.learnkotlin.di.AppModule
import com.wordpress.trinhbaloc.learnkotlin.di.news.DaggerNewsComponent
import com.wordpress.trinhbaloc.learnkotlin.di.news.NewsComponent


/**
 *
 * @author juancho.
 */
class KedditApp : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }
}