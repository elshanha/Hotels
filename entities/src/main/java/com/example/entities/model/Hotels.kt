package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Hotels (

	val id : Int?,
	val details : List<Details>,
	val rooms : List<Rooms?>?,
	val cached : Boolean?,
	val df : Boolean?,
	val fc : Boolean?
) : Parcelable