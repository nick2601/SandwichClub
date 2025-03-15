package com.nikhil.sandwichclubproject.data.remote

import com.nikhil.sandwichclubproject.data.model.Sandwich
import retrofit2.http.GET

// SandwichApiService.kt
interface SandwichApiService {
    @GET("sandwiches.json")
    suspend fun getSandwiches(): List<Sandwich>
}
