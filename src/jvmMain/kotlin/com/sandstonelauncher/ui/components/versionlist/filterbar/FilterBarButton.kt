package com.sandstonelauncher.ui.components.versionlist.filterbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sandstonelauncher.ui.NoAnimInteractionSource

@Composable
@Preview
fun FilterBarButton(text: String, onClick: () -> Unit, isChecked: () -> Boolean) {
    val checked = isChecked()

    val backgroundColorAnim = animateColorAsState(if (checked) Color(50, 50, 50) else Color.Transparent)

    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = backgroundColorAnim.value),
        modifier = Modifier.widthIn(50.dp, 200.dp).height(50.dp),
        interactionSource = NoAnimInteractionSource
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(text)

            if (checked) {
                Icon(Icons.Default.Close, "close", tint = Color.White)
            }
        }
    }
}
