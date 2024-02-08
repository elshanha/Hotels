package com.example.common.base

import androidx.lifecycle.ViewModel
import com.example.common.State
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel() : ViewModel() {
    val state : MutableStateFlow<State?> = MutableStateFlow(null)
}