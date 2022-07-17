package com.devincubator.keepintime.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            .fillMaxHeight(1F)
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

        Spacer(modifier = Modifier.height(10.dp))

        val meetingsOnToday = meetingsViewModel.meetingsOnToday
            .observeAsState(listOf()).value

        var tempQuantityMeetings = meetingsOnToday.size

        when (tempQuantityMeetings) {
            0 -> {
                for(i in MIN_MEETINGS_ON_A_DAY..MAX_MEETINGS_ON_A_DAY) {
                    Row(modifier = Modifier) {
                        SetMeetingDescription(viewModel = meetingsViewModel)
                        SetTimeOfMeeting(meetingsViewModel = meetingsViewModel)
                    }
                }
            }
            1 -> {
                meetingsOnToday.take(1).forEach { meeting ->
                    Row(modifier = Modifier) {
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
                while (tempQuantityMeetings + 1 != 0) {
                    Row(modifier = Modifier) {
                        SetMeetingDescription(viewModel = meetingsViewModel)
                        SetTimeOfMeeting(meetingsViewModel = meetingsViewModel)
                    }
                    tempQuantityMeetings--
                }
            }
            2 -> {
                meetingsOnToday.take(2).forEach { meeting ->
                    Row(modifier = Modifier) {
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
                Row(modifier = Modifier) {
                    SetMeetingDescription(viewModel = meetingsViewModel)
                    SetTimeOfMeeting(meetingsViewModel = meetingsViewModel)
                }
            }
            else -> {
                meetingsOnToday.take(3).forEach { meeting ->
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
}

@Preview(showBackground = false)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}