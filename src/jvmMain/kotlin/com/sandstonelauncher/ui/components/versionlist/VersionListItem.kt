package com.sandstonelauncher.ui.components.versionlist

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun VersionListItem(versionId: String, isDownload: Boolean, onDownloadClicked: () -> Unit) {
    var isHover by remember { mutableStateOf(false) }

    ListItem(
        modifier = Modifier
            .onPointerEvent(PointerEventType.Enter) {
                isHover = true
            }
            .onPointerEvent(PointerEventType.Exit) {
                isHover = false
            }
    ) {
        Row(Modifier.fillMaxWidth().height(25.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(versionId, style = MaterialTheme.typography.body2)

            Row(modifier = Modifier.wrapContentWidth().fillMaxHeight()) {
                if (isDownload) {
                    Icon(Icons.Default.CheckCircle, "check", tint = Color(200, 200, 200))
                }

                else if (isHover) {
                    IconButton({}) {
                        Icon(Icons.Default.ShoppingCart, "download", tint = Color(200, 200, 200))
                    }
                }
            }
        }
    }
}