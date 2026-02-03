package com.hmtest.androidnewsetup.data.source

import androidx.room.Dao
import androidx.room.Query
import com.hmtest.androidnewsetup.data.model.CountryCodeEntity
import com.hmtest.androidnewsetup.domain.model.CountryCode

@Dao
interface CountryCodeDao {
    @Query("""
        SELECT * FROM ${CountryCodeEntity.TABLE_NAME}
        WHERE ${CountryCodeEntity.ALPHA_2_CODE} = :alpha2Code
    """)
    suspend fun getCountryCodeByAlpha2(alpha2Code: String): CountryCode?

    @Query("""
        SELECT * FROM ${CountryCodeEntity.TABLE_NAME}
        WHERE ${CountryCodeEntity.ALPHA_3_CODE} = :alpha3Code
    """)
    suspend fun getCountryCodeByAlpha3(alpha3Code: String): CountryCode?

    @Query("""
        SELECT * FROM ${CountryCodeEntity.TABLE_NAME}
        WHERE ${CountryCodeEntity.NUMERIC_3_CODE} = :numeric3Code
    """)
    suspend fun getCountryCodeByNumeric3(numeric3Code: String): CountryCode?
}
