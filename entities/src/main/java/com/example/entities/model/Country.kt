package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Country (

	val code : String?,
	val name : String?
) : Parcelable