package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SortingMethods (

	val value : Int?,
	val text : String?,
	val default : Boolean?,
	val description : String?
) : Parcelable