package com.example.zenn_app.core.data.di

import com.example.zenn_app.core.data.repository.TrendBookRepository
import com.example.zenn_app.core.data.repository.TrendBookRepositoryImpl
import com.example.zenn_app.core.data.repository.TrendIdeaArticleRepository
import com.example.zenn_app.core.data.repository.TrendIdeaArticleRepositoryImpl
import com.example.zenn_app.core.data.repository.TrendTechArticleRepository
import com.example.zenn_app.core.data.repository.TrendTechArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindsTrendTechArticleRepository(
        trendTechArticleRepository: TrendTechArticleRepositoryImpl
    ): TrendTechArticleRepository

    @Binds
    fun bindsTrendIdeaArticleRepository(
        trendIdeaArticleRepository: TrendIdeaArticleRepositoryImpl
    ): TrendIdeaArticleRepository

    @Binds
    fun bindsTrendBookRepository(
        trendBookRepository: TrendBookRepositoryImpl
    ): TrendBookRepository
}
