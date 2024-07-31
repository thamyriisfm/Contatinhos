package com.tfmdev.contatinhos.data.local.event

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "event_table")
data class Event(
    @ColumnInfo(name = "event")
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var description: String,
    var date: String,
) : Parcelable