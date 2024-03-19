package com.lop.devtools.monstera.files.beh.spawnrules.conditions

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpawnDensityLimit {
    @SerializedName("surface")
    @Expose
    var surface: Int? = null

    @SerializedName("underground")
    @Expose
    var underground: Int? = null
}