package rharj.com.catching.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Main(
        @SerializedName("temp")
        @Expose
        val temp : Float,
        @SerializedName("pressure")
        @Expose
        val pressure : Int,
        @SerializedName("humidity")
        @Expose
        val humidity : Int,
        @SerializedName("temp_min")
        @Expose
        val tempMin : Float,
        @SerializedName("temp_max")
        @Expose
        val tempMax : Float
)
