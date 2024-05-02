package com.manuel.androidmasternuevo.supergeroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val results: List<SuperHeroItemResponse>
)

data class SuperHeroItemResponse(
    @SerializedName("id") val superHeroId: String,
    @SerializedName("name") val name:String,
    @SerializedName("image") val superHeroImage:SuperheroImageResponse
)

data class SuperheroImageResponse(@SerializedName("url") val url : String)