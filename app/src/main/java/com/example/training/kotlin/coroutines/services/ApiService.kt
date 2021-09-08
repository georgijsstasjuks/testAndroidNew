package com.example.training.kotlin.coroutines.services

import com.example.training.kotlin.coroutines.services.models.Repositories
import com.example.training.kotlin.coroutines.services.networking.GithubApi

class ApiService {

    private var api: GithubApi

    init {
        val retrofit = RetrofitFactory().getRetrofitInstance()
        api = retrofit.create(GithubApi::class.java)
    }

    suspend fun getData(request: String): Repositories = api.getDataFromApi(request)

}