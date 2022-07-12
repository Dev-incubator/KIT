package com.devincubator.keepintime.presentation.meetings.components

/*@Composable
fun CreateMeeting(
    textState: String,
    onTextChange: (String) -> Unit
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

    Row {
        OutlinedTextField(
            value = textState,
            onValueChange = { onTextChange(it) },
            label = { Text(stringResource(R.string.create_meeting)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(start = 10.dp, end = 10.dp)
                .heightIn(30.dp)
                .clickable { }
                .offset(y = (-10).dp),
            shape = RoundedCornerShape(18.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.edit_meeting_color)
            )
        )

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
}*/

/*@Preview(showBackground = true)
@Composable
fun CreateMeetingPreview() {
    CreateMeeting(
        textState = "",
        onTextChange = {}
    )
}*/
