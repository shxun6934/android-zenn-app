package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.data.translator.BookTranslator.asExternalModel
import com.example.zenn_app.core.model.data.Book
import com.example.zenn_app.core.network.ZennApi
import javax.inject.Inject

class TrendBookRepositoryImpl @Inject constructor(
    private val zennApi: ZennApi
) : TrendBookRepository {

    override suspend fun fetchTrendBooks(): List<Book> =
        zennApi.fetchTrendBooks().map { it.asExternalModel() }
}
