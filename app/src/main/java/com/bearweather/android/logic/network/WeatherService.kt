package com.bearweather.android.logic.network

import retrofit2.Call
import com.bearweather.android.BearWeatherApplication
import com.bearweather.android.logic.model.DailyResponse
import com.bearweather.android.logic.model.RealtimeResponse
import retrofit2.http.GET
import retrofit2.http.Path
interface WeatherService {
    @GET("v2.5/${BearWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng")lng:String,@Path("lat")lat:String):
            Call<RealtimeResponse>

    @GET("v2.5/${BearWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng")lng: String,@Path("lat")lat: String):
            Call<DailyResponse>
}