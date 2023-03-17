package pt.ipvc.parkingsolutions.presentation.parks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun ParksScreen(
    parksViewModel: ParksViewModel = hiltViewModel()
){
    val getData = parksViewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = rememberAsyncImagePainter(model = getData.image), contentDescription = null)
        Text(text = getData.name)
        Text(text = getData.location)
        Text(text = getData.nFreeSpaces.toString())
    }

}