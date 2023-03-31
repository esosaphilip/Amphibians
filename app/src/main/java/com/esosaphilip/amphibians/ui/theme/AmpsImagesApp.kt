package com.esosaphilip.amphibians.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.esosaphilip.amphibians.ui.theme.screens.AmphibiansViewModel
import com.esosaphilip.amphibians.ui.theme.screens.HomeScreen
import com.esosaphilip.amphibians.R

@Composable
fun AmpsImagesApp(viewModel: AmphibiansViewModel,modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val amphibiansViewModel: AmphibiansViewModel = viewModel
            HomeScreen(
                ampsUiState = amphibiansViewModel.ampsUiState
            )
        }
    }
}