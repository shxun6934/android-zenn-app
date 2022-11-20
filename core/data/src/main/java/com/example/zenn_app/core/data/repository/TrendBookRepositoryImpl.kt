package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.data.translator.BookTranslator.asExternalModel
import com.example.zenn_app.core.model.data.Book
import com.example.zenn_app.core.network.ZennApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TrendBookRepositoryImpl @Inject constructor(
    private val zennApi: ZennApi
) : TrendBookRepository {

    override fun fetchTrendBooks(): Flow<List<Book>> = flow {
        emit(zennApi.fetchTrendBooks().map { it.asExternalModel() })
    }.flowOn(Dispatchers.IO)
}
