package com.example.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Details (

	val id : String? = null,
	val slug : String? = null,
	val address : Address? = null,
	val coordinate : Coordinate? = null,
	val description : String? = null,
	val hotelInfoDescription : String? = null,
	val facilitiesGroup : List<String?>? = null,
	val suitabilities : List<String?>? = null,
	val hotelDescriptions : List<String?>? = null,
	val extra : Extra? = null,
	val name : String? = null,
	val images : List<String?>? = null,
	val starRating : Int? = null,
	val reviewScore : Int? = null,
	val reviews : String? = null,
	val reviewInfo : String? = null,
	val reviewScoreLocalized : String? = null,
	val generalReviewScoreNote : String? = null,
	val checkInTime : String? = null,
	val checkOutTime : String? = null,
	val domestic : Boolean? = null,
	val reviewsTotalCount : String? = null,
	val cityCenterPointDistance : Double? = null,
	val cityCenterPointDistanceName : String? = null,
	val hotelConcept : List<String?>? = null,
	val nearByHotels : String? = null,
	val covidInfo : String? = null,
	val imageTypes : List<String?>? = null,
	val hotelAutocompleteIcon : String? = null,
	val locationDistance : String? = null,
	val policies : Policies? = null
) : Parcelable