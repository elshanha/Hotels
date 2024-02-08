package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Rooms (

    val reference : String?,
    val type : Type?,
    val images : List<Images?>?,
    val offers : List<Offers?>?,
    val facilities : List<String?>?,
    val information : List<String?>?,
    val alerts : List<String?>?,
    val description : String?

) : Parcelable