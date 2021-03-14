package com.pmacademy.catsapp.cats.data

import com.pmacademy.catsapp.datasource.CatsService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

class CatsRepository @Inject constructor(
    private val catsService: CatsService,
    private val dispatcher: CoroutineDispatcher
) {
    private companion object {
        const val LIMIT = 15
        const val START_PAGE = 0
    }

    private val pageNumber = AtomicInteger(START_PAGE)

    suspend fun loadMore(): List<Cat> = withContext(dispatcher) {
        val cats = catsService.getCats(LIMIT, pageNumber.get())
        pageNumber.incrementAndGet()
        cats
    }
}
