package com.devincubator.keepintime.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.devincubator.keepintime.R
import com.devincubator.keepintime.presentation.meetings.components.MeetingsHeader
import com.himanshoe.kalendar.common.KalendarSelector
import com.himanshoe.kalendar.common.KalendarStyle
import com.himanshoe.kalendar.ui.Kalendar
import com.himanshoe.kalendar.ui.KalendarType

@Composable
fun MeetingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(1F)
            .background(colorResource(id = R.color.meetings_color))

    ) {
        MeetingsHeader()
        Kalendar(
            kalendarType = KalendarType.Firey(),
            onCurrentDayClick = { day, event ->
            //handle the date click listener
            },
            errorMessage = {
            //Handle the error if any
            },
            kalendarStyle = KalendarStyle(
                kalendarBackgroundColor = Color(R.color.edit_meeting_color),
                kalendarColor = Color.White,
                kalendarSelector = KalendarSelector.Circle(),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MeetingsScreenPreview() {
    MeetingsScreen()
}