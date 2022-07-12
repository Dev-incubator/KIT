package com.devincubator.keepintime.data.network

import androidx.room.*
import com.devincubator.keepintime.domain.models.Contact
import com.devincubator.keepintime.domain.models.Description
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Query("SELECT * FROM contacts JOIN descriptions "
    + "ON contacts.id = descriptions.id"
    )
    fun getAllContacts(): Flow<Map<Contact, List<Description>>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}