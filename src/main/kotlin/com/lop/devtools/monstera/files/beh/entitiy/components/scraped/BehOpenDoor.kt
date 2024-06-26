package com.lop.devtools.monstera.files.beh.entitiy.components.scraped

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lop.devtools.monstera.files.MonsteraRawFile

class BehOpenDoor : MonsteraRawFile() {
    @SerializedName("priority")
    @Expose
    var priority: Number? = null
        

    @SerializedName("close_door_after")
    @Expose
    var closeDoorAfter: Boolean? = null
        
}