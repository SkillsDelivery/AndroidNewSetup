package com.hmtest.androidnewsetup.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hmtest.androidnewsetup.data.model.CountryCodeEntity

@Database(
    entities = [
        CountryCodeEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryCodeDao(): CountryCodeDao

    companion object {
        /** The name of the app database. */
        const val DB_NAME = "AppDatabase"
    }
}
