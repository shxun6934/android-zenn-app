package com.example.zenn_app.network

import com.example.zenn_app.network.model.NetworkArticle
import com.example.zenn_app.network.model.NetworkBook
import retrofit2.http.GET

interface ZennApi {
    @GET("api/trendTech")
    suspend fun fetchTrendTechArticles(): List<NetworkArticle>

    @GET("api/trendIdea")
    suspend fun fetchTrendIdeaArticles(): List<NetworkArticle>

    @GET("api/trendBook")
    suspend fun fetchTrendBooks(): List<NetworkBook>
}
