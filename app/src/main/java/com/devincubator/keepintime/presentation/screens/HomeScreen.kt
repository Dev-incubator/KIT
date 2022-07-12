package com.devincubator.keepintime.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devincubator.keepintime.R
import com.devincubator.keepintime.core.Constants.Companion.MAX_MEETINGS_ON_A_DAY
import com.devincubator.keepintime.core.Constants.Companion.MIN_MEETINGS_ON_A_DAY
import com.devincubator.keepintime.presentation.contacts.components.ContactsSection
import com.devincubator.keepintime.presentation.meetings.components.*
import com.devincubator.keepintime.presentation.tasks.components.TasksSection
import com.devincubator.keepintime.viewmodels.MeetingsViewModel

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
    ) {
        MeetingsSection()
        ContactsSection()
        TasksSection()
    }
}

@Composable
fun MeetingsSection(meetingsViewModel: MeetingsViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.meetings_color))
    ) {
        MeetingsHeader()

        val meetingsOnToday = meetingsViewModel.meetingsOnToday
            .observeAsState(listOf()).value

        if(meetingsOnToday.isEmpty()) {
            for(i in MIN_MEETINGS_ON_A_DAY..MAX_MEETINGS_ON_A_DAY) {
                Row(modifier = Modifier) {
                    SetMeetingDescription(viewModel = meetingsViewModel)
                    SetTimeOfMeeting(meetingsViewModel = meetingsViewModel)
                }
            }
        } else {
            meetingsOnToday.forEach { meeting ->
                Row() {
                    MeetingDescriptionView(
                        meeting,
                        viewModel = meetingsViewModel
                    )
                    MeetingTimeView(
                        meeting,
                        viewModel = meetingsViewModel
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}