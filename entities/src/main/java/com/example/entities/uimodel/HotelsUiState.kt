package com.example.entities.uimodel

data class HotelsUiState(
    val hotels: List<HotelListUIModel?>
)

data class HotelListUIModel(
    var hotelId : String?,
    var hotelImage : String?,
    var hotelTitle : String?,
    val hotelPrice : Double?
)