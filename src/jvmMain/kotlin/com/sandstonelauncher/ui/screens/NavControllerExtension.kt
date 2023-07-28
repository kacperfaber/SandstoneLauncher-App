package com.sandstonelauncher.ui.screens

fun NavController.editProfile(profileName: String) {
    navigate(Screen.EditProfile, mapOf("profileName" to profileName))
}