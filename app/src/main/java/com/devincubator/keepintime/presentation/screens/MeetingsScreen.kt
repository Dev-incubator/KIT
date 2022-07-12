package com.devincubator.keepintime.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.devincubator.keepintime.R
import com.devincubator.keepintime.presentation.meetings.components.MeetingsHeader

@Composable
fun MeetingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(1F)
            .background(colorResource(id = R.color.meetings_color))

    ) {
        MeetingsHeader()
    }
}

@Preview(showBackground = true)
@Composable
fun MeetingsScreenPreview() {
    MeetingsScreen()
}