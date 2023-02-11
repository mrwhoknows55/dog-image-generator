package com.mrwhoknows.dogimagegenerator.util

import android.view.View

class SafeClickListener(
    private val defaultInterval: Long = 1000L,
    private val onSafeClick: (View) -> Unit
) : View.OnClickListener {
    private var lastClickTime: Long = 1000L
    override fun onClick(view: View) {
        val timeElapsed = System.currentTimeMillis() - lastClickTime
        if (timeElapsed < defaultInterval) {
            return
        }
        lastClickTime = System.currentTimeMillis()
        onSafeClick.invoke(view)
    }
}

fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}