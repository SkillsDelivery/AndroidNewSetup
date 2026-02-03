package com.hmtest.androidnewsetup.data.source

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.hmtest.androidnewsetup.data.model.CountryCodeEntity
import com.hmtest.androidnewsetup.data.model.ProfileEntity

@Database(
    entities = [
        CountryCodeEntity::class,
        ProfileEntity::class
    ],
    version = 2,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryCodeDao(): CountryCodeDao
    abstract fun profileDao(): ProfileDao

    companion object {
        /** The name of the app database. */
        const val DB_NAME = "AppDatabase"
    }
}
