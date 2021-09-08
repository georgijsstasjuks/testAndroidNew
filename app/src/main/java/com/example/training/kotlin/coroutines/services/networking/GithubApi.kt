package com.example.training.kotlin.coroutines.services.networking

import com.example.training.kotlin.coroutines.services.models.Repositories
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String) : Repositories
}