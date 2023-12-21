package kr.ac.kumoh.ce.s23termproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PerformanceViewModel() : ViewModel() {
    private val SERVER_URL = "https://port-0-s23termproj-1drvf2llomiqscb.sel5.cloudtype.app/"
    private val festivalApi: FestivalApi
    private val _performList = MutableLiveData<List<Performance>>()

    val performList: LiveData<List<Performance>>
        get() = _performList

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        festivalApi = retrofit.create(FestivalApi::class.java)
    }

    fun loadPerformances(festivalId: Int) {
        viewModelScope.launch {
            try {
                val response = festivalApi.getPerformances(festivalId)
                _performList.value = response
            } catch (e: Exception) {
                Log.e("fetchData()", e.toString())
            }
        }
    }

}