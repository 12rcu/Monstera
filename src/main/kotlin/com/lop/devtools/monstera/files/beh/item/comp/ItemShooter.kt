package com.lop.devtools.monstera.files.beh.item.comp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemShooter {
    @SerializedName("max_draw_duration")
    @Expose
    var maxDrawDuration: Number? = null

    @SerializedName("scale_power_by_draw_duration")
    @Expose
    var scalePowerByDrawDuration: Boolean? = null

    @SerializedName("charge_on_draw")
    @Expose
    var chargeOnDraw: Boolean? = null

    @SerializedName("ammunition")
    @Expose
    var ammunitionData: MutableList<Ammunition>? = null

    /**
     * can be called multiple times
     *
     * ```
     * ammunition {
     *     item = "custom_projectile"
     *     useOffhand = true
     *     searchInventory = true
     *     useInCreative = true
     * }
     * ```
     */
    fun ammunition(data: Ammunition.() -> Unit) {
        ammunitionData = (ammunitionData ?: mutableListOf()).apply { add(Ammunition().apply(data)) }
    }

    class Ammunition {
        @SerializedName("item")
        @Expose
        var item: String? = null

        @SerializedName("use_offhand")
        @Expose
        var useOffhand: Boolean? = null

        @SerializedName("search_inventory")
        @Expose
        var searchInventory: Boolean? = null

        @SerializedName("use_in_creative")
        @Expose
        var useInCreative: Boolean? = null
    }
}