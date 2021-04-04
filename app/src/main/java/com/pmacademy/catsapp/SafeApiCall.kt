package com.pmacademy.catsapp

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend inline fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    crossinline body: suspend () -> T
): ResponseResult<T> {
    return try {
        val result = withContext(dispatcher) {
            body()
        }
        ResponseResult.Success(result)
    } catch (e: Exception) {
        ResponseResult.Failure(e)
    }
}