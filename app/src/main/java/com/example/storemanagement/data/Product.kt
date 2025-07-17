package com.example.storemanagement.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize // Make sure this import is present

@Parcelize // This annotation does all the work for you!
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String, // In a real app, this would be a URL or resource ID
    val description: String
) : Parcelable