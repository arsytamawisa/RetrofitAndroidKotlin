package com.example.retrofit.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.data.GithubData
import com.example.retrofit.data.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel : ViewModel() {
    private var _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        initData()
    }

    private fun initData() {
        val call = GithubService.retrofitService.showList()
        call.enqueue(object : Callback<List<GithubData>> {
            override fun onFailure(call: Call<List<GithubData>>, t: Throwable) {
                _response.value = "FAILED"
            }
            override fun onResponse(call: Call<List<GithubData>>, response: Response<List<GithubData>>) {
                _response.value = "SUCCESS"
            }
        })
        _response.value = "test"
    }
}