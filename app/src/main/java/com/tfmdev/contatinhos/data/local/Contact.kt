package com.tfmdev.contatinhos.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "contact_table")
data class Contact(
    @ColumnInfo(name = "contact") @PrimaryKey(autoGenerate = false) val id: String,
    var name: String,
    var phoneNumber: Long,
    var isActive: Boolean
) : Parcelable