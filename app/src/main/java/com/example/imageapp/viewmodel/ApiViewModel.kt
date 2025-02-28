package com.example.imageapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imageapp.model.core.Either
import com.example.imageapp.model.models.ApiResponse
import com.example.imageapp.model.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val _images = MutableLiveData<ApiResponse>()
    val images: LiveData<ApiResponse> get() = _images

    private val _event = MutableLiveData<Event>()
    val event: LiveData<Event> get() = _event

    fun getImages(apiKey: String, query: String) {
        viewModelScope.launch {
            when (val response = apiRepository.getImages(apiKey, query)) {
                is Either.Success -> _images.postValue(response.value)
                is Either.Error -> _event.postValue(Event.Error("${response.value.message} "))
            }
            }

        }

        sealed class Event {
            data class Error(val message: String) : Event()
        }
    }