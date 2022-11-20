package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.model.data.Book
import kotlinx.coroutines.flow.Flow

interface TrendBookRepository {

    fun fetchTrendBooks(): Flow<List<Book>>
}
