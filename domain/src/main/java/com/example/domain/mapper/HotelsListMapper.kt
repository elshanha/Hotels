package com.example.domain.mapper

import com.example.entities.model.Details
import com.example.entities.model.HotelDetails
import com.example.entities.model.Hotels
import com.example.entities.model.Json4Kotlin_Base
import com.example.entities.model.Offers
import com.example.entities.model.Rooms
import com.example.entities.uimodel.HotelListUIModel
import com.example.entities.uimodel.HotelsUiState
import javax.inject.Inject

class HotelsListMapper @Inject constructor() : BaseMapper<Hotels?, HotelsUiState?> {
    override fun map(input: Hotels?): HotelsUiState {
        return HotelsUiState(
            hotels = input!!.getHotels()
        )
    }

    private fun Hotels.getHotels(): List<HotelListUIModel?> {
        return details.map {
            HotelListUIModel (
                hotelId = it.id,
                hotelImage = "",
                hotelTitle = it.name,
                hotelPrice = 0.0
            )
        } ?: listOf()
    }
}