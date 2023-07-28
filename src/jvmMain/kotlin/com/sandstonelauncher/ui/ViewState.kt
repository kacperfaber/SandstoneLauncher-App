package com.sandstonelauncher.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class ViewState {
    private var isBackButtonVisibleState = mutableStateOf(false)
    private var secondTitleState = mutableStateOf<String?>(null)

    var backButton
        set(value) {isBackButtonVisibleState.value = value}
        get() = isBackButtonVisibleState.value

    var secondTitle
        set(value) {secondTitleState.value = value}
        get() = secondTitleState.value
}

@Composable
fun rememberViewState(): ViewState = remember { mutableStateOf(ViewState()) }.value