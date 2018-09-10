package rharj.com.catching.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rharj.com.catching.app.MyApplication
import rharj.com.catching.utils.AppConstant

class Network{

    val retrofit = Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(CatchingClient(MyApplication.applicationContext()))
            .build()
}