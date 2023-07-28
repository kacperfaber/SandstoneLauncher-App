package com.sandstonelauncher.ui.screens.editProfile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sandstonelauncher.ui.screens.NavController

@Composable
fun EditProfileScreen(navController: NavController) {
    Column(Modifier.fillMaxSize().padding(10.dp)) {
        var name by remember { mutableStateOf("Kacper") }

        Text("Profile name", style = MaterialTheme.typography.body2)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            maxLines = 1
        )
    }
}