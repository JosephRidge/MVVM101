package com.jayr.mvvm.ui.screens.student_dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StudentScreen(
    studentViewModel: StudentViewModel = viewModel(),
    modifier: Modifier,
){

//    viewmodel data
    val student = studentViewModel.student.collectAsState()
    var studentName by remember { mutableStateOf(TextFieldValue("")) }
    var studentAge by remember { mutableStateOf(TextFieldValue()) }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text(text = "Student Name") },
            maxLines = 1
        )
        OutlinedTextField(
            value = studentAge,
            onValueChange = { studentAge = it },
            label = { Text(text = "Age") },
            minLines = 1
        )

        OutlinedButton(
            onClick = {
                studentViewModel.createStudent(
                    name = studentName.text,
                    age = studentAge.text.toInt()
                )
            }
        ) {
            Text(text = "Create Student")
        }
        HorizontalDivider()
        Text(
            text = student.value.name
        )
        Text(
            text = "I am ${student.value.age} years old!"
        )
    }
}