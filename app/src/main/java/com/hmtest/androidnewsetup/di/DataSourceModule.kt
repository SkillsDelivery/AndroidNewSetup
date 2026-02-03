package com.hmtest.androidnewsetup.di

import com.hmtest.androidnewsetup.data.source.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    companion object {
        @Provides
        @Singleton
        fun providesCountryCodeDao(
            database: AppDatabase
        ) = database.countryCodeDao()

    }
}
