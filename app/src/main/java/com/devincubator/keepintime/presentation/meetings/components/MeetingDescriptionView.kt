package com.devincubator.keepintime.presentation.meetings.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotStarted
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devincubator.keepintime.domain.models.Meeting
import com.devincubator.keepintime.viewmodels.MeetingsViewModel

@Composable
fun MeetingDescriptionView(
    meeting: Meeting,
    viewModel: MeetingsViewModel
){
    val scrollState = rememberScrollState()

    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Filled.NotStarted,
            contentDescription = "",
            tint = Color.Cyan,
            modifier = Modifier
                .padding(start = 10.dp, top = 5.dp)
                .size(21.dp)
        )
        Text(
            text = meeting.description,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                .horizontalScroll(scrollState),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
    }
}