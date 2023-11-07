package com.lop.devtools.monstera.files.beh.entitiy.components

import com.lop.devtools.monstera.files.beh.entitiy.data.BehEntityFilter
import org.slf4j.LoggerFactory

class ComponentEntitySensor {
    val general = mutableMapOf<String, Any>()
    private val logger = LoggerFactory.getLogger("Component Entity Sensor")

    var sensorRange: Float? = null
    var relativeRange: Boolean? = null
    var requireAll: Boolean? = null
    var minimumCount: Int? = null
    var maximumCount: Int? = null
    var event: String? = null

    fun eventFilters(value: BehEntityFilter.() -> Unit) {
        general["event_filters"] = BehEntityFilter().apply(value).getData()
    }

    fun getData(): MutableMap<String, Any> {
        sensorRange?.let { general["sensor_range"] = it }
        relativeRange?.let { general["relative_range"] = it }
        requireAll?.let { general["require_all"] = it }
        minimumCount?.let {
            general["minimum_count"] = it
            if (it == 0)
                logger.warn("minimumCount cant be 0 as the sensor can't check this -> work with inverse filters!")
        }
        maximumCount?.let {
            general["maximum_count"] = it
            if (it == 0)
                logger.warn("minimumCount cant be 0 as the sensor can't check this -> work with inverse filters!")
        }
        event?.let { general["event"] = it }
        return general
    }
}