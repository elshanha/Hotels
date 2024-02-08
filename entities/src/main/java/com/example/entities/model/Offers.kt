package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Offers (

	val hotels : List<Hotels?>?,
	val totalCount : Int?,
	val availableCount : Int?
) : Parcelable