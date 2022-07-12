package com.devincubator.keepintime.domain.repository

import com.devincubator.keepintime.domain.models.Contact
import com.devincubator.keepintime.domain.models.Description
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun getAllContacts(): Flow<Map<Contact, List<Description>>>

    suspend fun insertContact(contact: Contact)

    suspend fun deleteContact(contact: Contact)
}