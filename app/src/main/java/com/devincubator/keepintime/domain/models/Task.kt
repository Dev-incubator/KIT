package com.devincubator.keepintime.domain.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @NonNull @ColumnInfo(name = "descriptionId") val descriptionId: Int
)
