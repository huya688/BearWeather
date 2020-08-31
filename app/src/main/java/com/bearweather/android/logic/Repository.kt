package com.bearweather.android.logic

import androidx.lifecycle.liveData
import com.bearweather.android.logic.network.BearWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object Repository {
    fun searchPlaces(query:String)= fire(Dispatchers.IO){
            val placeResponse = BearWeatherNetwork.searchPlaces(query)
            if (placeResponse.status=="ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
    }
    private fun <T> fire(context:CoroutineContext,block:suspend ()->Result<T>)= liveData<Result<T>>(context) {
        val result =try{
        block()
        }catch (e:Exception){
        Result.failure<T>(e)
        }
        emit(result)
    }
}
