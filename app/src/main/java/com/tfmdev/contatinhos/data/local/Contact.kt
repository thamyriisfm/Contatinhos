package com.tfmdev.contatinhos.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
class Contact(
    @ColumnInfo(name = "contact")
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val phoneNumber: Long,
    val isActive: Boolean
) {
}