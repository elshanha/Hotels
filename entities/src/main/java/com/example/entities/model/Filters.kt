package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Filters (

	val min : Min?,
	val max : Max?,
	val title : String?,
	val name : String?,
	val icon : String?,
	val type : String?,
	val items : List<String?>?
) : Parcelable