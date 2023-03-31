package com.esosaphilip.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.esosaphilip.amphibians.ui.theme.AmphibiansTheme
import com.esosaphilip.amphibians.ui.theme.AmpsImagesApp
import com.esosaphilip.amphibians.ui.theme.screens.AmphibiansViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                AmphibiansTheme {
                    val viewModel: AmphibiansViewModel =
                         viewModel(factory = AmphibiansViewModel.Factory)
                    AmpsImagesApp(viewModel)
                }
        }
    }
}

