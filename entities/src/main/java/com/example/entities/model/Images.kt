package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Images (

	val url : String?,
	val name : String?,
	val type : String?
) : Parcelable