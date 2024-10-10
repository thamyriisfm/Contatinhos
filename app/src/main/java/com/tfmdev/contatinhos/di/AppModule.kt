package com.tfmdev.contatinhos.di

import android.content.Context
import androidx.room.Room
import com.tfmdev.contatinhos.BuildConfig
import com.tfmdev.contatinhos.data.local.contact.ContactDao
import com.tfmdev.contatinhos.data.local.contact.ContactRoomDatabase
import com.tfmdev.contatinhos.data.local.event.EventDao
import com.tfmdev.contatinhos.data.local.event.EventRoomDatabase
import com.tfmdev.contatinhos.data.remote.AdviceSlipAPI
import com.tfmdev.contatinhos.data.remote.AdviceSlipHelper
import com.tfmdev.contatinhos.data.remote.AdviceSlipService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseUrl() = "https://api.adviceslip.com"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    } else {
        OkHttpClient.Builder().build()
    }

    @Provides
    fun provideLogDao(database: ContactRoomDatabase): ContactDao {
        return database.contactDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ContactRoomDatabase {
        return Room.databaseBuilder(
            appContext, ContactRoomDatabase::class.java, "contact_database"
        ).build()
    }

    @Provides
    fun provideLogDaoEvent(database: EventRoomDatabase): EventDao {
        return database.eventDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabaseEvent(@ApplicationContext appContext: Context): EventRoomDatabase {
        return Room.databaseBuilder(
            appContext, EventRoomDatabase::class.java, "event_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseURl: String): Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseURl)
            .client(okHttpClient).build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(AdviceSlipAPI::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(adviceSlipHelper: AdviceSlipService): AdviceSlipHelper = adviceSlipHelper

}