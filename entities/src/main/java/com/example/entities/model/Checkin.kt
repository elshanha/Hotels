package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Checkin (

	val begin_time : String,
	val end_time : String
) : Parcelable