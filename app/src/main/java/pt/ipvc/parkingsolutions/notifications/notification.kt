package pt.ipvc.parkingsolutions.notifications

import android.app.PendingIntent
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.ipvc.parkingsolutions.MainActivity

@Composable
fun notification(title: String, message: String) {
  Column {
    Text(text = title)
    Text(text = message)
  }
}

@Preview
@Composable
fun PreviewGreeting() {
  notification(title = "Title", message = "Message")
}
