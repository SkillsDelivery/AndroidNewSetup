package com.hmtest.androidnewsetup.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = ProfileEntity.TABLE_NAME
)
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id: Long = AUTO_ID,

    @ColumnInfo(name = PERSONAL_NUMBER)
    val personalNumber: String,

    @ColumnInfo(name = FIRST_NAME_COL)
    val firstName: String,

    @ColumnInfo(name = LAST_NAME_COL)
    val lastName: String,
) {
    companion object {
        const val TABLE_NAME: String = "Profile"
        const val ID: String = "id"
        const val PERSONAL_NUMBER: String = "personalNumber"
        const val FIRST_NAME_COL: String = "firstName"
        const val LAST_NAME_COL: String = "lastName"
        const val AUTO_ID: Long = 0L
    }
}
