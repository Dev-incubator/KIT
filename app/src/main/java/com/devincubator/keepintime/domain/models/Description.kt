package com.devincubator.keepintime.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "descriptions")
data class Description(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")  val id: Int,
    @ColumnInfo(name = "description") val description: String
)
