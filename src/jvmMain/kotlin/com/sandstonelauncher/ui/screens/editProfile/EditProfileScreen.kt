package com.sandstonelauncher.ui.screens.editProfile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sandstonelauncher.data.LauncherProfile
import com.sandstonelauncher.ui.screens.NavController

@Composable
private fun InputString(label: String, value: String, onValueChanged: (value: String) -> Unit) {
    Column(Modifier.fillMaxWidth().padding(0.dp, 9.dp)) {
        Text(modifier = Modifier.padding(0.dp, 3.dp), text = label, style = MaterialTheme.typography.h3)
        TextField(value, onValueChanged, maxLines = 1)
    }
}

@Composable
private fun EditProfileForm(launcherProfile: LauncherProfile) {
    var profileName by remember { mutableStateOf(launcherProfile.name) }
    var gameDir by remember { mutableStateOf(launcherProfile.gameDir) }
    var javaDir by remember { mutableStateOf(launcherProfile.javaDir) }
    var javaArgs by remember { mutableStateOf(launcherProfile.javaArgs) }
    var lastVersionId by remember { mutableStateOf(launcherProfile.javaArgs) }
    var resolutionW by remember { mutableStateOf(launcherProfile.resolution.width) }
    var resolutionH by remember { mutableStateOf(launcherProfile.resolution.height) }

    val scrollState = rememberScrollState(0)

    Column(Modifier.fillMaxSize().verticalScroll(scrollState)) {
        InputString("Profile name: ", profileName) { profileName = it }

        InputString("Game directory: ", gameDir) { gameDir = it }

        InputString("Java Directory: ", javaDir) { javaDir = it }

        InputString("Java Arguments: ", javaArgs) { javaArgs = it }

        InputString("Last Version Id: ", lastVersionId) { lastVersionId = it }

        InputString("Resolution / Width", resolutionW.toString()) { resolutionW = it.toInt() }

        InputString("Resolution / Height", resolutionH.toString()) { resolutionH = it.toInt() }

        Row(Modifier.fillMaxWidth().height(50.dp), horizontalArrangement = Arrangement.End) {
            OutlinedButton({}) {
                Icon(Icons.Default.ExitToApp, "cancel", tint = Color(200, 200, 200))
                Text("Cancel")
            }

            OutlinedButton({}) {
                Icon(Icons.Default.Done, "done", tint = Color(200, 200, 200))
                Text("Save")
            }
        }
    }
}

@Composable
fun EditProfileScreen(navController: NavController) {
    val viewModel by remember { mutableStateOf(EditProfileScreenViewModel()) }

    LaunchedEffect(Unit) {
        viewModel.loadProfileByName(navController.requireString("profileName"))
    }

    Column(Modifier.fillMaxSize().padding(10.dp)) {
        if (viewModel.launcherProfile != null) {
            EditProfileForm(viewModel.launcherProfile!!)
        } else {
            Text("ładowanie danych profilu...") // TODO: i18
        }
    }
}