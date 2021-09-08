package com.example.training.kotlin.coroutines.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.training.kotlin.coroutines.services.models.Repositories
import com.example.training.kotlin.coroutines.services.networking.GithubApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoroutineViewModel: ViewModel() {

    private val repositories = MutableLiveData<Repositories>()
    private val service = ApiService()

    fun repositories(): LiveData<Repositories> = repositories

    fun getAllData(request: String)  {
        viewModelScope.launch(Dispatchers.IO) {
            val response = service.getData(request)
            repositories.postValue(response)
        }

    }

}