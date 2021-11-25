package com.example.countries.network

import androidx.lifecycle.Transformations.map
import com.squareup.moshi.Json
import java.util.*


data class CountryPhoto(
    @Json (name = "name") val name : String,
    @Json (name = "flag") val flag : String
)

data class Phototresponse(
    val error : Boolean ,
    val msg : String,
    @Json (name = "data")
    val data : List<CountryPhoto>
)