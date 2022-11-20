package com.example.zenn_app.data.repository

import com.example.zenn_app.data.translator.BookTranslator.asExternalModel
import com.example.zenn_app.model.data.Book
import com.example.zenn_app.network.ZennApi
import javax.inject.Inject

class TrendBookRepositoryImpl @Inject constructor(
    private val zennApi: ZennApi
) : TrendBookRepository {

    override suspend fun fetchTrendBooks(): List<Book> =
        zennApi.fetchTrendBooks().map { it.asExternalModel() }
}
