package com.hmtest.androidnewsetup.data.utils

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hmtest.androidnewsetup.data.model.CountryCodeEntity
import com.hmtest.androidnewsetup.domain.model.CountryCode

class CountryCodeDbCallback() : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        // Build the SQL query to insert the country codes into the database
        val query = StringBuilder()
            .append("INSERT INTO CountryCode (")
            .append(CountryCodeEntity.NUMERIC_3_CODE).append(", ")
            .append(CountryCodeEntity.ALPHA_2_CODE).append(", ")
            .append(CountryCodeEntity.ALPHA_3_CODE).append(") ")
            .append("VALUES (?, ?, ?)")
            .toString()

        db.beginTransaction()
        try {
            // Insert the country codes into the database one by one
            getMockCountryCodes().forEach { countryCode ->
                db.execSQL(
                    query,
                    arrayOf(
                        countryCode.numeric3Code,
                        countryCode.alpha2Code,
                        countryCode.alpha3Code
                    )
                )
            }
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }
    }

    private fun getMockCountryCodes(): List<CountryCode> = listOf(
        CountryCode(1, "840", "US", "USA"),
        CountryCode(2, "124", "CA", "CAN"),
        CountryCode(3, "826", "GB", "GBR"),
        CountryCode(4, "752", "SE", "SWE"),
        CountryCode(5, "276", "DE", "DEU"),
        CountryCode(6, "036", "AU", "AUS"),
        CountryCode(7, "352", "IS", "ISL"),
        CountryCode(8, "642", "RO", "ROU")
    )
}
