package com.example.hotels.viewmodels

import com.example.common.Resource
import com.example.common.State
import com.example.common.base.BaseViewModel
import com.example.domain.mapper.HotelsListMapper
import com.example.domain.usecase.HotelsUseCase
import com.example.entities.model.Details
import com.example.entities.uimodel.HotelListUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HotelsViewModel @Inject constructor(
    private val useCase: HotelsUseCase,
    private val mapper: HotelsListMapper
) : BaseViewModel() {

    private val _hotels = MutableStateFlow<List<HotelListUIModel>>(
        listOf(
            HotelListUIModel(
                hotelId = "123",
                hotelImage = "456",
                hotelTitle = "789",
                hotelPrice = 10.0
            )
        )
    )
    val hotels = _hotels.asStateFlow()

    suspend fun getFlights() {
        useCase.getHotelList().collectLatest {
            when (it) {
                is Resource.Error -> state.emit(State.error(it.message))
                is Resource.Loading -> state.emit(State.loading())
                is Resource.Success -> {
                    state.emit(State.success())
                    it.data?.let {
//                        val mappedData = mapper.map(it)

                        _hotels.update { it }
                    }
                }
            }
        }
    }
}