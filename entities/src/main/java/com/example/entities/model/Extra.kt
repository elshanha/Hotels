package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Extra (

	val image_count : Int?,
	val thumbnailImage : String?
) : Parcelable