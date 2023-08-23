package com.example.fantasyfootballgame.data

import com.example.fantasyfootballgame.model.BoostrapStatic.BootstrapStaticCall
import retrofit2.Response
import retrofit2.http.GET

interface FPLApiService {

    @GET("bootstrap-static/")
    suspend fun getBootstrap(): Response<BootstrapStaticCall>

}