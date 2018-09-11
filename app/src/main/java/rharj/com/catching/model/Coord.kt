package rharj.com.catching.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coord (
    @SerializedName("lon")
    @Expose
    val lon : Float,

    @SerializedName("lat")
    @Expose
    val lat : Float
)
