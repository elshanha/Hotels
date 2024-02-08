package com.example.entities.model

import android.os.Parcelable
import com.example.entities.model.Checkin
import com.example.entities.model.Fees
import kotlinx.parcelize.Parcelize


@Parcelize
data class Policies (

	val checkin : Checkin?,
	val checkout : String?,
	val instructions : String?,
	val special_instructions : String?,
	val checkin_min_age : String?,
	val fees : Fees?,
	val know_before_you_go : String?
) : Parcelable