package ru.coolhabit.marvelheroes

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.coolhabit.marvelheroes.ioc.DaggerApplicationComponent
import ru.marvelheroes.comicsdetails.notifications.NotificationConstants.CHANNEL_ID

class MarvelApp : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //Задаем имя, описание и важность канала
            val name = "WatchLaterChannel"
            val descriptionText = "MarvelHeroes notification Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            //Создаем канал, передав в параметры его ID(строка), имя(строка), важность(константа)
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            //Отдельно задаем описание
            mChannel.description = descriptionText
            //Получаем доступ к менеджеру нотификаций
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //Регистрируем канал
            notificationManager.createNotificationChannel(mChannel)
        }
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
            .factory()
            .create(this)
    }

}