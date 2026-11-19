package com.example.localgson.remote

import com.example.localgson.model.Todo
import retrofit2.http.GET

interface TodoApiService {
    @GET("/todos")
    suspend fun getTodos(): List<Todo>
}