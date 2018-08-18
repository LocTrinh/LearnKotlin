@file:JvmName("ExtensionsUtils")
package com.wordpress.trinhbaloc.learnkotlin.commons


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}