package com.sandstonelauncher.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.sandstonelauncher.ui.screens.home.tabs.HomeTab
import com.sandstonelauncher.ui.screens.home.tabs.version.VersionTab

private class Tab(
    val title: String,
    val component: @Composable () -> Unit
)

private val homeTabs = mapOf(
    0 to Tab("Home") { HomeTab() },
    1 to Tab("Versions") { VersionTab() }
)

@Composable
fun HomeTabView(modifier: Modifier = Modifier) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(modifier) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            homeTabs.forEach { (index, tab) ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(tab.title, style = MaterialTheme.typography.body2) }
                )
            }
        }

        (homeTabs[selectedTabIndex]?.component ?: throw Exception("No tab found with $selectedTabIndex"))
            .invoke()
    }
}