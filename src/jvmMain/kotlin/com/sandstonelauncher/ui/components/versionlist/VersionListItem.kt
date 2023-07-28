package com.sandstonelauncher.ui.components.versionlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun VersionListItem(versionId: String, isDownload: Boolean) {
    ListItem {
        Row(Modifier.fillMaxWidth().height(25.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(versionId, style = MaterialTheme.typography.body2)

            if (isDownload) {
                Icon(Icons.Default.CheckCircle, "check", tint = Color(200, 200, 200))
            }
        }
    }
}