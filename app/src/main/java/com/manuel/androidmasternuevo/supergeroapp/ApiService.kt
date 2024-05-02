package com.manuel.androidmasternuevo.supergeroapp


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/122121947324105667/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superheroName: String,) : Response<SuperHeroDataResponse>

    @GET("https://superheroapi.com/api/122121947324105667/{id}")
    suspend fun getSuperHeroID(@Path("id") superheroId:String):Response<SuperHeroDatailresponse>
}