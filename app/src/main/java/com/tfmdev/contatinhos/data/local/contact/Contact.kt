package com.tfmdev.contatinhos.data.local.contact

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "contact_table")
data class Contact(
    @ColumnInfo(name = "contact")
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var name: String,
    var phoneNumber: String,
    var isActive: Boolean
) : Parcelable