package com.example.domain.di

import com.example.data.repository.HotelsRepositoryInterface
import com.example.domain.usecase.HotelsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseDi {

    @Provides
    @Singleton
    fun provideHotelsUseCase(repositoryInterface: HotelsRepositoryInterface) = HotelsUseCase(repositoryInterface)
}