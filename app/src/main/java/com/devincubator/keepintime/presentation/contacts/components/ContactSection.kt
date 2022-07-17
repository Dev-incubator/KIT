package com.devincubator.keepintime.presentation.contacts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Group
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devincubator.keepintime.R

@Composable
fun ContactsSection() {
    val contactName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.contacts_color))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Outlined.Group,
                contentDescription = "meetings",
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 10.dp)
            )
            Text(
                text = stringResource(R.string.contacts),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                fontSize = 35.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        ContactNameAndButton()

        Spacer(modifier = Modifier.heightIn(2.dp))

        EditContactName(
            value = contactName,
            onValueChange = {}
        )
    }
}

@Composable
fun ContactNameAndButton() {
    Row(
        modifier = Modifier.padding(start = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp),
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = "Alexander",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W300,
                    fontSize = 25.sp,
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(start = 10.dp),
                    shape = RoundedCornerShape(40),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = "3 темы",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp),
                verticalAlignment = Alignment.Bottom
            ){
                Text(
                    text = "Alexey",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W300,
                    fontSize = 25.sp,
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(start = 10.dp),
                    shape = RoundedCornerShape(40),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = "2 темы",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
        }

        Column(
           modifier = Modifier.wrapContentSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Balislau",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W300,
                    fontSize = 25.sp,
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(start = 10.dp),
                    shape = RoundedCornerShape(40),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = "4 темы",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp),
                verticalAlignment = Alignment.Bottom
            ){
                Text(
                    text = "Matvey",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W300,
                    fontSize = 25.sp,
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(start = 10.dp),
                    shape = RoundedCornerShape(40),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = "2 темы",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun EditContactName(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .heightIn(30.dp),
        shape = RoundedCornerShape(18.dp),
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.choose_contact_from_phone)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = R.color.edit_contact_color)
        )
    )
}

@Preview
@Composable
fun ContactSectionView() {
    ContactsSection()
}