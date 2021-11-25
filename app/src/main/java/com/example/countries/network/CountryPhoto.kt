package com.example.countries.network

import androidx.lifecycle.Transformations.map
import com.squareup.moshi.Json
import java.util.*

data class CountryPhoto(
    val name : String,
     val flag : String
)

data class Phototresponse(
    val error : Boolean ,
    val msg : String,
    val data : List<CountryPhoto>
)



