package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coordinate (

	val longitude : Double?,
	val latitude : Double?
) : Parcelable