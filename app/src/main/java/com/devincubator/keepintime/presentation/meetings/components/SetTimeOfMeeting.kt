package com.devincubator.keepintime.presentation.meetings.components

import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devincubator.keepintime.R
import com.devincubator.keepintime.viewmodels.MeetingsViewModel
import java.util.*

@Composable
fun SetTimeOfMeeting(
    meetingsViewModel: MeetingsViewModel
) {
    // Fetching local context
    val context = LocalContext.current

    // Init the calendar
    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR]
    val minute = calendar[Calendar.MINUTE]

    val time = remember { mutableStateOf("") }

    val timePickerDialog = TimePickerDialog(
        context,
        {_, hours: Int, minutes: Int ->
            time.value = "$hours:$minutes"
        }, hour, minute, true
    )

    Column(
        modifier = Modifier
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = { timePickerDialog.show() },
            label = { Text(stringResource(id = R.string.select_time)) },
            singleLine = true,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .heightIn(30.dp)
                .clickable { }
                .offset(y = (-10).dp),
            shape = RoundedCornerShape(18.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.edit_meeting_color)
            )
        )
    }
}