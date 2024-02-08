package com.example.network.api

import com.example.entities.model.HotelDetails
import com.example.entities.model.Hotels
import com.example.entities.model.Offers
import com.example.entities.model.Rooms
import retrofit2.http.GET


interface HotelApiService {

    @GET("hotels")
    suspend fun getHotels() : Hotels

    // https://65a7624794c2c5762da692dd.mockapi.io/api/v1/
}