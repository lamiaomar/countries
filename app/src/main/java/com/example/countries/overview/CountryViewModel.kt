package com.example.countries.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.network.CountryApi
import com.example.countries.network.CountryPhoto
import kotlinx.coroutines.launch
import java.util.*

class CountryViewModel : ViewModel() {


    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status


    init {
        getCountryPhotos()
    }


    private fun getCountryPhotos() {


        viewModelScope.launch {
            try {
                val listResult = CountryApi.retrofitService.getPhotos()
                _status.value = "Success: ${listResult} Country photos retrieved"

            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}