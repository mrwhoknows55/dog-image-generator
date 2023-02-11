package com.mrwhoknows.dogimagegenerator.di

import android.content.Context
import com.mrwhoknows.dogimagegenerator.DogApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesApplication(@ApplicationContext context: Context): DogApplication =
        (context as DogApplication)
}