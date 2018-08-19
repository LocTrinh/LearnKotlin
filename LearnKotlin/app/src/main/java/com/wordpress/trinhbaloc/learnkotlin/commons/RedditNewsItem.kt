package com.wordpress.trinhbaloc.learnkotlin.commons
import com.wordpress.trinhbaloc.learnkotlin.commons.adapter.AdapterConstants
import com.wordpress.trinhbaloc.learnkotlin.commons.adapter.ViewType


data class RedditNewsItem (
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
): ViewType{
    override fun getViewType() = AdapterConstants.NEWS

}
