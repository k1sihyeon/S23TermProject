package kr.ac.kumoh.ce.s23termproject

import retrofit2.http.GET
import retrofit2.http.Path

interface FestivalApi {
    @GET("festival")
    suspend fun getFestivals(): List<Festival>

    @GET("festival/{id}")
    suspend fun getPerformances(@Path("id") id: Int): List<Performance>
}