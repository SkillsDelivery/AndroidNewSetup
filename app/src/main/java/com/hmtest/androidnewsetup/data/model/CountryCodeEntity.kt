package com.hmtest.androidnewsetup.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CountryCodeEntity.TABLE_NAME)
data class CountryCodeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id: Long = AUTO_ID,

    @ColumnInfo(name = NUMERIC_3_CODE)
    val numeric3Code: String,

    @ColumnInfo(name = ALPHA_2_CODE)
    val alpha2Code: String,

    @ColumnInfo(name = ALPHA_3_CODE)
    val alpha3Code: String
) {
    companion object {
        const val TABLE_NAME: String = "CountryCode"
        const val ID: String = "id"
        const val NUMERIC_3_CODE: String = "numeric3Code"
        const val ALPHA_2_CODE: String = "alpha2Code"
        const val ALPHA_3_CODE: String = "alpha3Code"
        const val AUTO_ID: Long = 0L
    }
}
