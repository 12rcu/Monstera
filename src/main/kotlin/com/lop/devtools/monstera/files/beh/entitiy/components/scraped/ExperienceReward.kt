package com.lop.devtools.monstera.files.beh.entitiy.components.scraped

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lop.devtools.monstera.files.MonsteraRawFile

class ExperienceReward : MonsteraRawFile() {
    @SerializedName("on_bred")
    @Expose
    var onBred: String? = null
        
    @SerializedName("on_death")
    @Expose
    var onDeath: String? = null
}