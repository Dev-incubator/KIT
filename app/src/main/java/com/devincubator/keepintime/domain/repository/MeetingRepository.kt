package com.devincubator.keepintime.domain.repository

import androidx.lifecycle.LiveData
import com.devincubator.keepintime.data.network.MeetingDao
import com.devincubator.keepintime.domain.models.Meeting
import java.util.*

class MeetingRepository(private val meetingDao: MeetingDao) {

    private val calendar: Calendar = Calendar.getInstance()

    val getAllMeetings: LiveData<List<Meeting>> = meetingDao.getAllMeetings()
    val getMeetingsOnToday: LiveData<List<Meeting>> = meetingDao.getMeetingsByDayOfMonth(13)

    suspend fun getMeetingsByDayOfMonth(dayOfMonth: Int) {
        meetingDao.getMeetingsByDayOfMonth(dayOfMonth)
    }

    suspend fun insertMeeting(meeting: Meeting) {
        meetingDao.insertMeeting(meeting)
    }

    suspend fun deleteMeetingById(meeting: Meeting) {
        meetingDao.deleteMeetingById(meeting)
    }
}