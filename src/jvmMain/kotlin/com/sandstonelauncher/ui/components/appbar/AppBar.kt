package com.sandstonelauncher.ui.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sandstonelauncher.typography
import com.sandstonelauncher.ui.ViewState

@Composable
fun AppBar(viewState: ViewState, exit: () -> Unit, minimize: () -> Unit, goBack: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp)
            .background(Color(45, 45, 45))
            .padding(15.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (viewState.backButton) {
            IconButton(goBack) {
                // TODO: No 'minimize' icon, I'm using 'Icon.Menu' actually.
                Icon(Icons.Default.ArrowBack, "back", tint = Color(200, 200, 200))
            }
        }

        Text("App Title", style = typography.body1) // TODO: i18

        if (viewState.secondTitle != null) {
            Text("\t${viewState.secondTitle}") // TODO: Replace \t with dot icon [dot separator]
        }

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