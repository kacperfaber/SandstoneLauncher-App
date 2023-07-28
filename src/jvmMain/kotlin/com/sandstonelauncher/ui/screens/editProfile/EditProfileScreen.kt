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
import com.sandstonelauncher.ui.viewmodels.EditLauncherProfileViewModel
import kotlinx.coroutines.launch

@Composable
private fun InputString(label: String, value: String, onValueChanged: (value: String) -> Unit) {
    Column(Modifier.width(250.dp).padding(3.dp, 9.dp)) {
        Text(modifier = Modifier.padding(0.dp, 3.dp), text = label, style = MaterialTheme.typography.h3)
        TextField(value, onValueChanged, maxLines = 1)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun EditProfileForm(launcherProfile: LauncherProfile, navigateUp: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    val viewModel by remember { mutableStateOf(EditLauncherProfileViewModel(launcherProfile)) }

    FlowRow(modifier = Modifier.fillMaxWidth()) {
        InputString("Profile name: ", viewModel.profileName.value) { viewModel.profileName.value = it }

        InputString("Game directory: ", viewModel.gameDir.value) { viewModel.gameDir.value = it }

        InputString("Java Directory: ", viewModel.javaDir.value) { viewModel.javaDir.value = it }

        InputString("Java Arguments: ", viewModel.javaArgs.value) { viewModel.javaArgs.value = it }

        InputString("Last Version Id: ", viewModel.lastVersionId.value) { viewModel.lastVersionId.value = it }

        InputString("Resolution / Width", viewModel.resolutionW.value.toString()) { viewModel.resolutionW.value = it.toInt() }

        InputString("Resolution / Height", viewModel.resolutionH.value.toString()) { viewModel.resolutionH.value = it.toInt() }
    }

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth().height(50.dp), horizontalArrangement = Arrangement.End) {
            OutlinedButton(navigateUp) {
                Icon(Icons.Default.ExitToApp, "cancel", tint = Color(200, 200, 200))
                Text("Cancel")
            }

            OutlinedButton({coroutineScope.launch { viewModel.saveProfile(); navigateUp() }}) {
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
            EditProfileForm(viewModel.launcherProfile!!, navigateUp = {navController.navigateUp()})
        } else {
            Text("ładowanie danych profilu...") // TODO: i18
        }
    }
}