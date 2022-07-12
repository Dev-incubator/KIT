package com.devincubator.keepintime.domain.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meetings")
data class Meeting(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @NonNull @ColumnInfo(name = "repeatability")
    var repeatability: Boolean,
    @ColumnInfo(name = "year")
    var year: Int,
    @ColumnInfo(name = "month")
    var month: Int,
    @ColumnInfo(name = "dayOfMonth")
    var dayOfMonth: Int,
    @ColumnInfo(name = "hour")
    var hour: Int,
    @ColumnInfo(name = "minute")
    var minute: Int,
    @ColumnInfo(name = "description")
    var description: String
)