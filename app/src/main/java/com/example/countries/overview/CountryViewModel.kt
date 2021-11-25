package com.example.countries.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.network.CountryApi
import com.example.countries.network.CountryPhoto
import com.example.countries.network.Phototresponse
import kotlinx.coroutines.launch
import java.util.*

class CountryViewModel : ViewModel() {


    private val _status = MutableLiveData<List<CountryPhoto>>()
    val status: LiveData<List<CountryPhoto>> = _status

    private val _flag = MutableLiveData<String>()
    val flag: LiveData<String> = _flag

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    init {
        getCountryPhotos()
    }

    private fun getCountryPhotos() {

        viewModelScope.launch {
            try {
                _status.value = CountryApi.retrofitService.getPhotos().data

                _name.value = _status.value.toString()

            } catch (e: Exception) {
                _name.value = "Failure: ${e.message}"
            }

        }
    }
}