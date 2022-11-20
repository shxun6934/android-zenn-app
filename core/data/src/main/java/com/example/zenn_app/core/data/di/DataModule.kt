package com.example.zenn_app.core.data.di

import com.example.zenn_app.core.data.repository.*
import com.example.zenn_app.data.repository.*
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
