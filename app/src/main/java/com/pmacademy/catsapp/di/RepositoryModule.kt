package com.pmacademy.catsapp.di

import com.pmacademy.catsapp.cats.data.CatsRepository
import com.pmacademy.catsapp.datasource.CatsService
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCatsRepository(catsService: CatsService): CatsRepository {
        return CatsRepository(catsService, Dispatchers.IO)
    }
}
