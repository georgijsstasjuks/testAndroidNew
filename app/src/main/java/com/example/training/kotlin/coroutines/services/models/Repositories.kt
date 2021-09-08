package com.example.training.kotlin.coroutines.services.models

data class Repositories(val items: ArrayList<Data>)
data class Data(val name: String, val description: String, val owner: Owner)
data class Owner(val avatarUrl: String )