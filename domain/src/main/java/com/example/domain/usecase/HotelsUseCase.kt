package com.example.domain.usecase

import com.example.common.Resource
import com.example.data.repository.HotelsRepositoryInterface
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotelsUseCase @Inject constructor(private val repoInterface: HotelsRepositoryInterface) {
    suspend fun getHotelList() = flow {
        emit(Resource.Loading())
        repoInterface.getHotels()?.let {
            emit(Resource.Success(it))
        } ?: emit(Resource.Error("Error"))
    } .catch { e ->
        emit(Resource.Error(e.localizedMessage))
    }

}