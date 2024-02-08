package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Result (

    val requestId : String?,
    val funnelId : String?,
    val offers : Offers?,
    val filters : List<Filters?>?,
    val sortingMethods : List<SortingMethods?>?,
    val searchUrl : String?
) : Parcelable