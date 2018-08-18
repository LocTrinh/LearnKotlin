package com.wordpress.trinhbaloc.learnkotlin.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.wordpress.trinhbaloc.learnkotlin.commons.adapter.ViewType
import com.wordpress.trinhbaloc.learnkotlin.commons.adapter.ViewTypeDelegateAdapter
import com.wordpress.trinhbaloc.learnkotlin.R
import com.wordpress.trinhbaloc.learnkotlin.commons.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)){

    }
}
