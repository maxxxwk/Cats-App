package com.pmacademy.catsapp

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LinearUIPagination(
    recyclerView: RecyclerView,
    loadMore: () -> Unit,
    elementsCountBeforeLoadMore: Int = 15
) {

    private var isLoading = false

    init {
        val linearLayoutManager = (recyclerView.layoutManager as? LinearLayoutManager)
            ?: throw IllegalStateException("LinearUiPagination works only with LinearLayoutManager")
        recyclerView.adapter?.registerAdapterDataObserver(object :
            RecyclerView.AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                isLoading = false
            }
        })
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (isLoading) {
                    return
                }
                val lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition()
                val itemsCount = recyclerView.adapter?.itemCount ?: return
                if (lastVisiblePosition > itemsCount - elementsCountBeforeLoadMore) {
                    isLoading = true
                    loadMore()
                }
            }
        })
    }
}