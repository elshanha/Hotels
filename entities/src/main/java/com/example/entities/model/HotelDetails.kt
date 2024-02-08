package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HotelDetails(
    val hotelDetails : List<Details?>?
) : Parcelable
