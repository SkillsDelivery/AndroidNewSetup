package com.hmtest.androidnewsetup.data.source

import androidx.room.Dao
import androidx.room.Query
import com.hmtest.androidnewsetup.data.model.ProfileEntity
import com.hmtest.androidnewsetup.domain.model.Profile

@Dao
fun interface ProfileDao {
    @Query("""
        SELECT * FROM ${ProfileEntity.TABLE_NAME}
        WHERE ${ProfileEntity.PERSONAL_NUMBER} = :personalNumber
    """)
    suspend fun getProfile(personalNumber: String): Profile?
}
