package pt.ipvc.parkingsolutions.presentation.parks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import pt.ipvc.parkingsolutions.ui.components.CardItem

@Composable
fun ParksScreen(
    parksViewModel: ParksViewModel = hiltViewModel()
){
    val parks = parksViewModel.state.value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(parks){each ->
            CardItem(name = each.name, location = each.location, nFreeSpaces = each.nFreeSpaces, image = each.image)
        }
    }

}