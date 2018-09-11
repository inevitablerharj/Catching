package rharj.com.catching.services

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rharj.com.catching.app.MyApplication
import rharj.com.catching.model.ResponseData
import rharj.com.catching.utils.AppConstant

interface NetworkService {

    @GET("data/2.5/weather")
    fun search(@Query("q") query : String,
               @Query("appid") appid : String): Call<ResponseData>

    companion object {
        fun create(): NetworkService{

            val retrofit = Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(CatchingClient(MyApplication.applicationContext()))
                    .build()

            return retrofit.create(NetworkService::class.java)

        }
    }
}