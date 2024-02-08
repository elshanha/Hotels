package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Campaign_banners (

	val domestic : List<Domestic?>?,
	val international : List<String?>?
) : Parcelable