package com.bearweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.bearweather.android.BearWeatherApplication
import com.bearweather.android.logic.model.Place
import com.google.gson.Gson

object PlaceDao {
    fun savePlace(place: Place){
        sharedPreferences().edit{
            putString("Place",Gson().toJson(place))
        }
    }
    fun getSavedPlace():Place{
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)

    }
    fun isPlaceSaved()= sharedPreferences().contains("place")
    private fun sharedPreferences()=BearWeatherApplication.context.getSharedPreferences("bear_weather",Context.MODE_PRIVATE)
}