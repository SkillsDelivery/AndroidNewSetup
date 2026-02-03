package com.hmtest.androidnewsetup.di

import android.content.Context
import androidx.room.Room
import com.hmtest.androidnewsetup.data.source.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module to provide database for injection.
 * Installed in Singleton Component.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext appContext: Context,
    ): AppDatabase = Room
        .databaseBuilder(
            appContext,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        )
        .build()
}
