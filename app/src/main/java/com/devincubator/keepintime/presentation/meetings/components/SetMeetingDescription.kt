package com.devincubator.keepintime.presentation.meetings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.devincubator.keepintime.R
import com.devincubator.keepintime.viewmodels.MeetingsViewModel

@Composable
fun SetMeetingDescription(
    viewModel: MeetingsViewModel,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = viewModel.meetingDescriptionState,
        onValueChange = viewModel.onMeetingDescriptionChange,
        label = { Text(stringResource(R.string.create_meeting)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .heightIn(30.dp)
            .padding(start = 10.dp, end = 10.dp)
            .clickable { }
            .offset(y = (-10).dp),
        shape = RoundedCornerShape(18.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = R.color.edit_meeting_color)
        )
    )
}
