package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.model.data.Book

interface TrendBookRepository {

    suspend fun fetchTrendBooks(): List<Book>
}
