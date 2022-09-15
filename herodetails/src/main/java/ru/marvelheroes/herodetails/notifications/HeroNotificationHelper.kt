package ru.marvelheroes.herodetails.notifications

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.transition.Transition
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import ru.marvelheroes.comicsdetails.notifications.NotificationConstants
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.herodetails.R

object HeroNotificationHelper {
    fun createNotification(context: Context, hero: Hero?, activity: AppCompatActivity?) {
        val mIntent = Intent(context, activity?.classLoader?.javaClass)
        val pendingIntent =
            PendingIntent.getActivity(context, 0, mIntent, PendingIntent.FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(context, NotificationConstants.CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_watch_later)
            setContentTitle(context.resources.getString(R.string.watch_later_text))
            setContentText(hero?.heroName)
            priority = NotificationCompat.PRIORITY_DEFAULT
            setContentIntent(pendingIntent)
            setAutoCancel(true)
        }
        val notificationManager = NotificationManagerCompat.from(context)

        Glide.with(context)
            .asBitmap()
            .load(hero?.heroPoster)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                }
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    builder.setStyle(NotificationCompat.BigPictureStyle().bigPicture(resource))
                    hero?.heroId?.let { notificationManager.notify(it.toInt(), builder.build()) }
                }
            })
        hero?.heroId?.let { notificationManager.notify(it.toInt(), builder.build()) }
    }
}
