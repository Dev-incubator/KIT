package com.devincubator.keepintime.presentation.meetings.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devincubator.keepintime.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MeetingsHeader() {
    var checked by remember { mutableStateOf(false) }

    var datePicked: String? by remember {
        mutableStateOf(null)
    }
    val updatedDate = { date: Long? ->
        datePicked = date?.toString()?:""
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(end = 10.dp)
            .fillMaxWidth(1F)
    ) {
        Icon(
            imageVector = Icons.Outlined.ThumbUp,
            contentDescription = "meetings",
            modifier = Modifier
                .size(40.dp)
                .padding(start = 10.dp)
        )
        Text(
            text = stringResource(R.string.meetings),
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = getCurrentDate(),
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = 17.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        DatePickerView(updatedDate)
    }
}

@SuppressLint("SimpleDateFormat")
private fun getCurrentDate(): String {
    val dateFormat: DateFormat = SimpleDateFormat("EEEE, d MMM yyyy")
    return dateFormat.format(Calendar.getInstance().time).toString()
}

@Preview(showBackground = true)
@Composable
fun MeetingsHeaderView() {
    MeetingsHeader()
}