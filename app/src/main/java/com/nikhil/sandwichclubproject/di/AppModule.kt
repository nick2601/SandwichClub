package com.nikhil.sandwichclubproject.di

import android.content.Context
import com.nikhil.sandwichclubproject.data.local.SandwichDataSource
import com.nikhil.sandwichclubproject.data.repository.SandwichRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideSandwichDataSource(@ApplicationContext context: Context): SandwichDataSource {
        return SandwichDataSource(context)
    }

    @Singleton
    @Provides
    fun provideSandwichRepository(dataSource: SandwichDataSource): SandwichRepository {
        return SandwichRepository(dataSource)
    }
}