package rharj.com.catching.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import rharj.com.catching.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import rharj.com.catching.model.ResponseData
import rharj.com.catching.services.NetworkService
import rharj.com.catching.utils.AppConstant

class MainActivity : AppCompatActivity() {

    private var responseData: ResponseData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val searchWord = location.text.toString()
            makeCall(searchWord,AppConstant.API_KEY)
        }
    }

    fun makeCall(city : String, apiKey : String){

       val networkService = NetworkService.create()
       val call =  networkService.search(city,apiKey)
        call.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: retrofit2.Response<ResponseData>?) {
                if(response !=null){
                    responseData = response.body()
                    result.setText(responseData?.coord.toString())
                }

            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {

            }
        })
    }

    fun showData(){

    }
}
