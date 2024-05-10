package com.tfmdev.contatinhos

import android.app.Application
import com.google.android.material.color.DynamicColors
import com.tfmdev.contatinhos.data.local.ContactRepository
import com.tfmdev.contatinhos.data.local.ContactRoomDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class ContatinhosApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ContactRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ContactRepository(database.contactDao()) }

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }

}