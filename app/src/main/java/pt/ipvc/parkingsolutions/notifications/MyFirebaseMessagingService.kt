package pt.ipvc.parkingsolutions.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import pt.ipvc.parkingsolutions.MainActivity
import pt.ipvc.parkingsolutions.R

const val channelId = "notification_channel"
const val channelName = "pt.ipvc.parkingsolutions.notifications"
class MyFirebaseMessagingService : FirebaseMessagingService() {

  override fun onMessageReceived(remoteMessage: RemoteMessage) {
    if(remoteMessage.getNotification() != null){
      generateNotifications(remoteMessage.notification!!.title!!, remoteMessage.notification!!.body!!)
    }
  }

  fun generateNotifications(title: String, message: String) {

    val intent = Intent(this, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

    val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

    //channel id, channel name
    var builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
      .setSmallIcon(R.drawable.img)
      .setContentTitle(title)
      .setContentText(message)
      .setAutoCancel(true)
      .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
      .setOnlyAlertOnce(true)
      .setContentIntent(pendingIntent)

    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(notificationChannel)
    }

    notificationManager.notify(0, builder.build())
  }
}
