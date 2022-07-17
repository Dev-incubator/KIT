package com.devincubator.keepintime.presentation.tasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DriveFileRenameOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devincubator.keepintime.R

@Composable
fun TasksSection() {
    var firstTaskDescription by remember { mutableStateOf("") }
    var secondTaskDescription by remember { mutableStateOf("") }
    var thirdTaskDescription by remember { mutableStateOf("") }
    var fourthTaskDescription by remember { mutableStateOf("") }
    var fifthTaskDescription by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(1f)
        .background(colorResource(id = R.color.tasks_color))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(1F),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Outlined.DriveFileRenameOutline,
                contentDescription = "meetings",
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 10.dp)
            )
            Text(
                text = stringResource(R.string.tasks),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                fontSize = 35.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        
        EditTask(
            value = firstTaskDescription,
            onValueChange = { firstTaskDescription = it }
        )
        EditTask(
            value = secondTaskDescription,
            onValueChange = { secondTaskDescription = it }
        )
        EditTask(
            value = thirdTaskDescription,
            onValueChange = { thirdTaskDescription = it }
        )
        EditTask(
            value = fourthTaskDescription,
            onValueChange = { fourthTaskDescription = it }
        )
        EditTask(
            value = fifthTaskDescription,
            onValueChange = { fifthTaskDescription = it }
        )
    }
}

