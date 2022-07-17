package com.devincubator.keepintime.presentation.meetings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devincubator.keepintime.domain.models.Meeting
import com.devincubator.keepintime.viewmodels.MeetingsViewModel

@Composable
fun MeetingTimeView(
    meeting: Meeting,
    viewModel: MeetingsViewModel
) {
    /*val context = LocalContext.current
    val mViewModel: MeetingsViewModel = viewModel(
        factory = MeetingsViewModel.MeetingViewModelFactory(context.applicationContext as Application)
    )*/
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "${meeting.hour}:${meeting.minute}0",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W300,
            fontSize = 28.sp,
            maxLines = 1
        )
    }
}


