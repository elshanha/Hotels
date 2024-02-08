package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoomClass (

	val code : String?,
	val description : String?,
	val refundable : Boolean?,
	val promotion : Boolean?,
	val packages : Boolean?,
	val offer : Boolean?
) : Parcelable