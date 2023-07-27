package com.sandstonelauncher.ui.components.profilelist

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import com.sandstonelauncher.AppTheme
import com.sandstonelauncher.colorScheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun ProfileItem(name: String, versionId: String, isSelected: Boolean, onClick: () -> Unit, onSettingsClicked: () -> Unit) {
    ListItem(
        Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(5.dp)
            .border(0.dp, Color.Transparent, RoundedCornerShape(5.dp))
            .combinedClickable(onClick = onClick)
    ) {
        Row(Modifier.fillMaxWidth().wrapContentHeight(), verticalAlignment = Alignment.CenterVertically) {
            if (isSelected) {
                Icon(
                    Icons.Default.Check,
                    "Check",
                    tint = colorScheme.onSurface,
                    modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp)
                )
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text(name, style = MaterialTheme.typography.h4)
                    Text(versionId, style = MaterialTheme.typography.body2)
                }

                if (isSelected) {
                    IconButton(onSettingsClicked) {
                        Icon(Icons.Default.Settings, "Settings", tint = colorScheme.onSurface)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ProfileItemPreview() {
    AppTheme {
        ProfileItem("kacperek", "1.19.2", true,
            onClick = {},
            onSettingsClicked = {}
        )
    }
}