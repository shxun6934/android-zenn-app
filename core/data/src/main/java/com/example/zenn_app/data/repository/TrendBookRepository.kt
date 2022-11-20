package com.example.zenn_app.data.repository

import com.example.zenn_app.model.data.Book

interface TrendBookRepository {

    suspend fun fetchTrendBooks(): List<Book>
}
