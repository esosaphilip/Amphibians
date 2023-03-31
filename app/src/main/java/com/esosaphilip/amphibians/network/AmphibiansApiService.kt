package com.esosaphilip.amphibians.network

import retrofit2.Call
import retrofit2.http.GET


private const val Base_Url = " https://android-kotlin-fun-mars-server.appspot.com/amphibians"




interface AmphibiansApiService {

    @GET("amphibians")
   suspend fun getDatas(): List<AmphimItem>

}