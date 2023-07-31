package com.sandstonelauncher.ui.components.versionlist.filterbar

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sandstonelauncher.ui.screens.home.tabs.version.VersionTabViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterBar(viewModel: VersionTabViewModel) {
    FlowRow(Modifier.fillMaxWidth().wrapContentHeight()) {
        FilterBarButton(
            text = "Show Only Installed",
            onClick = { viewModel.showOnlyInstalledVersions = !viewModel.showOnlyInstalledVersions },
            isChecked = { viewModel.showOnlyInstalledVersions }
        )

        FilterBarButton(
            text = "Show Release",
            onClick = { viewModel.showRelease = !viewModel.showRelease },
            isChecked = { viewModel.showRelease }
        )

        FilterBarButton(
            text = "Show Snapshots",
            onClick = { viewModel.showSnapshots = !viewModel.showSnapshots },
            isChecked = { viewModel.showSnapshots }
        )
    }
}