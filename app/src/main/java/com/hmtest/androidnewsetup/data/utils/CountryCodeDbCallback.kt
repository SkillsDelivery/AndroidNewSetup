package com.hmtest.androidnewsetup.data.utils

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hmtest.androidnewsetup.data.model.CountryCodeEntity

class CountryCodeDbCallback() : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        // Build the SQL query to insert the country codes into the database
        val query = StringBuilder()
            .append("INSERT INTO ${CountryCodeEntity.TABLE_NAME} (")
            .append(CountryCodeEntity.NUMERIC_3_CODE).append(", ")
            .append(CountryCodeEntity.ALPHA_2_CODE).append(", ")
            .append(CountryCodeEntity.ALPHA_3_CODE).append(") ")
            .append("VALUES (?, ?, ?)")
            .toString()

        db.beginTransaction()
        try {
            // Insert the country codes into the database one by one
            getMockCountryCodes().forEach { countryCodeEntity ->
                db.execSQL(
                    query,
                    arrayOf(
                        countryCodeEntity.numeric3Code,
                        countryCodeEntity.alpha2Code,
                        countryCodeEntity.alpha3Code
                    )
                )
            }
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }
    }

    private fun getMockCountryCodes(): List<CountryCodeEntity> = listOf(
        CountryCodeEntity(numeric3Code = "840", alpha2Code = "US", alpha3Code = "USA"),
        CountryCodeEntity(numeric3Code = "124", alpha2Code = "CA", alpha3Code = "CAN"),
        CountryCodeEntity(numeric3Code = "826", alpha2Code = "GB", alpha3Code = "GBR"),
        CountryCodeEntity(numeric3Code = "752", alpha2Code = "SE", alpha3Code = "SWE"),
        CountryCodeEntity(numeric3Code = "276", alpha2Code = "DE", alpha3Code = "DEU"),
        CountryCodeEntity(numeric3Code = "036", alpha2Code = "AU", alpha3Code = "AUS"),
        CountryCodeEntity(numeric3Code = "352", alpha2Code = "IS", alpha3Code = "ISL"),
        CountryCodeEntity(numeric3Code = "642", alpha2Code = "RO", alpha3Code = "ROU")
    )
}
