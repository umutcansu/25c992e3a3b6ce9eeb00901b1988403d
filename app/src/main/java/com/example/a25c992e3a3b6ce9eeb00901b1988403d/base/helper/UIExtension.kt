package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.helper

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object UIExtension {
    fun RecyclerView.getCurrentPosition() : Int {
        return (this.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    }
}