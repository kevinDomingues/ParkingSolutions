package pt.ipvc.parkingsolutions.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CardItem(name: String, location: String, nFreeSpaces: Int, image: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(280.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.White,
        elevation = 10.dp,
        border = BorderStroke(0.5.dp,Color.DarkGray)
    ){
        Column {
            Image(
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = location,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black,
                    fontSize = 13.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row() {
                    Text(
                        text = "Free Spaces: ",
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Black,
                        fontSize = 13.sp,
                    )
                    Text(
                        text = nFreeSpaces.toString(),
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Green,
                        fontSize = 13.sp,
                    )
                }

            }
        }

    }
}

@Preview
@Composable
fun DefaultPreview() {
    CardItem(name = "Name", location = "Location", nFreeSpaces = 2, image = "https://radiogeice.com/wp-content/uploads/2020/04/parque-encosta-do-elevador-viana-do-castelo.jpg")
}
