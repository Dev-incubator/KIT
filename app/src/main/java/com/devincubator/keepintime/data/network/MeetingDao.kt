package com.devincubator.keepintime.data.network

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devincubator.keepintime.domain.models.Meeting

@Dao
interface MeetingDao {
    @Query("SELECT * FROM meetings")
    fun getAllMeetings(): LiveData<List<Meeting>>

    @Query("SELECT * FROM meetings WHERE dayOfMonth = :dayOfMonth ORDER BY hour ASC")
    fun getMeetingsByDayOfMonth(dayOfMonth: Int) : LiveData<List<Meeting>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeeting(meeting: Meeting)

    //@Query("DELETE FROM meetings WHERE id = :id")
    @Delete
    suspend fun deleteMeetingById(meeting: Meeting)
}