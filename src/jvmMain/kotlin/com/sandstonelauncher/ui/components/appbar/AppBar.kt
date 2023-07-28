package com.sandstonelauncher.ui.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sandstonelauncher.typography

@Composable
fun AppBar(exit: () -> Unit, minimize: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp)
            .background(Color(45, 45, 45))
            .padding(15.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("App Title", style = typography.body1) // TODO: i18

        Row(Modifier.fillMaxHeight().wrapContentWidth()) {
            IconButton(minimize) {
                // TODO: No 'minimize' icon, I'm using 'Icon.Menu' actually.
                Icon(Icons.Default.Menu, "minimize", tint = Color(200, 200, 200))
            }

            IconButton(exit) {
                Icon(Icons.Default.Close, "close", tint = Color(200, 200, 200))
            }
        }
    }
}