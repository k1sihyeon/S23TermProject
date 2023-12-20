package kr.ac.kumoh.ce.s23termproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class FestivalViewModel() : ViewModel() {
    private val SERVER_URL = "https://port-0-s23termproj-1drvf2llomiqscb.sel5.cloudtype.app/"
    private val festivalApi: FestivalApi
    private val _festivalList = MutableLiveData<List<Festival>>()
    val festivalList: LiveData<List<Festival>>
        get() = _festivalList

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        festivalApi = retrofit.create(FestivalApi::class.java)
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val response = festivalApi.getFestivals()
                _festivalList.value = response
            } catch (e: Exception) {
                Log.e("fetchData()", e.toString())
            }
        }
    }
}