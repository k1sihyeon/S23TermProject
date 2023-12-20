package kr.ac.kumoh.ce.s23termproject

import retrofit2.http.GET

interface FestivalApi {
    @GET("festival")
    suspend fun getFestivals(): List<Festival>
}