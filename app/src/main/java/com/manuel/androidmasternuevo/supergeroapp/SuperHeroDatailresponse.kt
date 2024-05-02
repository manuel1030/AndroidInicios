package com.manuel.androidmasternuevo.supergeroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDatailresponse(
            @SerializedName("name") val name:String,
            @SerializedName("powerstats") val powerstats :  PowerstatsResponse,
            @SerializedName("image") val image: imgResponse,
            @SerializedName("biography") val biography : biographyResponse,
            @SerializedName("connections") val connections : connectionsResponse
            )


data class  PowerstatsResponse(
    @SerializedName("intelligence") val intelligence:String,
    @SerializedName("strength") val strength:String,
    @SerializedName("speed")  val speed:String,
    @SerializedName("durability") val durability:String,
    @SerializedName("power") val power:String,
    @SerializedName("combat") val combat:String
)

data class biographyResponse(
    @SerializedName("full-name") val  fullbname :String,
    @SerializedName("alter-egos") val alteregos: String,
    @SerializedName("place-of-birth") val placeofbirth : String,
    @SerializedName("first-appearance") val firstappearance : String,
    @SerializedName("publisher") val publisher : String,
    @SerializedName("alignment") val alignment : String
)
data class imgResponse(@SerializedName("url") val url :String )
data class connectionsResponse(@SerializedName("group-affiliation") val groupaaffiliation : String)

