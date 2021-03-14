package com.pmacademy.catsapp.datasource

import com.pmacademy.catsapp.cats.data.Cat
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsService {
    @GET("/v1/images/search")
    suspend fun getCats(@Query("limit") limit: Int, @Query("page") page: Int): List<Cat>
}
