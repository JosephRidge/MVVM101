package com.jayr.mvvm.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jayr.mvvm.data.models.HobbyDataModel

@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = viewModel(),
    modifier: Modifier
) {
    var hobby by remember { mutableStateOf(HobbyDataModel()) }
    var hobbyName by remember { mutableStateOf(TextFieldValue("")) }
    var hobbyDescription by remember { mutableStateOf(TextFieldValue("")) }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = hobbyName,
            onValueChange = { hobbyName = it },
            label = { Text(text = "Hobby Name") },
            maxLines = 1
        )
        OutlinedTextField(
            value = hobbyDescription,
            onValueChange = { hobbyDescription = it },
            label = { Text(text = "Hobby Description") },
            minLines = 3
        )

        OutlinedButton(
            onClick = {

            }
        ) {
            Text(text = "Create Hobby")
        }
    }
}

fun createHobby(name:String, description:String): HobbyDataModel{
    return HobbyDataModel(name= name, description = description)
}