package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address (

	val address : String?,
	val zipCode : Int?,
	val country : Country?,
	val countryCode : String?,
	val town : Town?,
	val city : City?
) : Parcelable