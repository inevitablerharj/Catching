package rharj.com.catching.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wind (
        @SerializedName("speed")
        @Expose
        val speed : Float,

        @SerializedName("deg")
        @Expose
        val deg : Int
)