package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Type (

	val id : String?,
	val name : String?,
	val typeCode : String?,
	val characteristicCode : String?
) : Parcelable