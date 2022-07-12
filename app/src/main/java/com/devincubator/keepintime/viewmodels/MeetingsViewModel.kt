package com.devincubator.keepintime.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.devincubator.keepintime.data.db.KeepInTimeDb
import com.devincubator.keepintime.domain.models.Meeting
import com.devincubator.keepintime.domain.repository.MeetingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MeetingsViewModel(application: Application): AndroidViewModel(application) {

    private val meetingRepository: MeetingRepository
    val allMeetings: LiveData<List<Meeting>>
    val meetingsOnToday: LiveData<List<Meeting>>

    init {
        val meetingDao = KeepInTimeDb.getDatabase(application).meetingDao()
        meetingRepository = MeetingRepository(meetingDao)
        allMeetings = meetingRepository.getAllMeetings
        meetingsOnToday = meetingRepository.getMeetingsOnToday
    }

    var isOutlinedTextFieldVisible by mutableStateOf(false)
    var meetingDescriptionState by mutableStateOf("Встреча с Александром")
    val onMeetingDescriptionChange = { text: String -> meetingDescriptionState = text }

    fun getMeetingByDayOfMonth(dayOfMonth: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            meetingRepository.getMeetingsByDayOfMonth(dayOfMonth)
        }
    }

    fun insertMeeting(meeting: Meeting) {
        viewModelScope.launch(Dispatchers.IO) {
            meetingRepository.insertMeeting(meeting)
        }
    }

    fun deleteMeeting(id: Meeting) {
        viewModelScope.launch(Dispatchers.IO) {
            meetingRepository.deleteMeetingById(id)
        }
    }

    class MeetingViewModelFactory(
        private val application: Application
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            if (modelClass.isAssignableFrom(MeetingsViewModel::class.java)) {
                return MeetingsViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModelClass")
        }
    }
}