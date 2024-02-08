package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Json4Kotlin_Base (

    val responseCode : Int?,
    val errors : String?,
    val message : String?,
    val result : Result?,
    val campaign_banners : Campaign_banners?
) : Parcelable