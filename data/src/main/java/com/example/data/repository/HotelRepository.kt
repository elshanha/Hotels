package com.example.data.repository

import com.example.common.Resource
import com.example.entities.model.Details
import com.example.entities.model.Hotels
import com.example.network.api.HotelApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

interface HotelsRepositoryInterface {
    suspend fun getHotels() : Hotels?


}

class HotelRepository @Inject constructor(private val api : HotelApiService) : HotelsRepositoryInterface {
        override suspend fun getHotels(): Hotels {
                return api.getHotels()
    }

}