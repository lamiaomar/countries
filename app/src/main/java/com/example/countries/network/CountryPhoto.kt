package com.example.countries.network

import com.squareup.moshi.Json

data class CountryPhoto(
    @Json (name = "name") val name : String,
    @Json (name = "flag") val flag : String
)
