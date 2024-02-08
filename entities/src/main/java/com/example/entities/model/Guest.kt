package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Guest (

	val adults : Int?,
	val children : Int?
) : Parcelable