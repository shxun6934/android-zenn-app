package com.example.zenn_app.core.domain.use_case

import com.example.zenn_app.core.data.repository.TrendBookRepository
import com.example.zenn_app.core.domain.model.TrendBook
import com.example.zenn_app.core.domain.translator.TrendBookTranslator.asAppModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookUseCase @Inject constructor(
    private val bookRepository: TrendBookRepository
) {
    fun fetchTrendBooks(): Flow<List<TrendBook>> =
        bookRepository.fetchTrendBooks().map { books ->
            books.map { it.asAppModel() }
        }
}
