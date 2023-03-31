package com.esosaphilip.amphibians.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.esosaphilip.amphibians.R
import com.esosaphilip.amphibians.network.Amphim
import com.esosaphilip.amphibians.network.AmphimItem

@Composable
fun HomeScreen(
    ampsUiState: AmpsUiState,
    modifier: Modifier = Modifier

){
    when (ampsUiState) {
        is AmpsUiState.Loading -> LoadingScreen(modifier)
        is AmpsUiState.Success ->  PhotosGridScreen(ampsUiState.amps , modifier)
        is AmpsUiState.Error -> ErrorScreen(retryAction = modifier,modifier)

    }
}
@Composable
fun AmphibiansCard(amp: AmphimItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = 8.dp,
    ) {
        Column(){
            Text(text = amp.name,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
                )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amp.imgSrc)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = stringResource(R.string.amps_image),
                contentScale = ContentScale.FillBounds
            )
           Text(
               text = amp.description,
               style = MaterialTheme.typography.body1,
               textAlign = TextAlign.Justify,
               modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
           )
        }

    }
}

    @Composable
    fun ErrorScreen(retryAction: Modifier, modifier: Modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(R.string.loading_failed))
        }
    }

    @Composable
    fun PhotosGridScreen(amps: List<AmphimItem>, modifier: Modifier) {
        LazyColumn{
            items(amps) { amps ->
                AmphibiansCard(amps)
            }
        }

    }

    @Composable
    fun LoadingScreen(modifier: Modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier.size(200.dp),
                painter = painterResource(R.drawable.loading_img),
                contentDescription = stringResource(R.string.loading)
            )
        }
    }


