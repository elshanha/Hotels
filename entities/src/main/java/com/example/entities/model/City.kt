package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City (

	val id : String?,
	val name : String?
) : Parcelable