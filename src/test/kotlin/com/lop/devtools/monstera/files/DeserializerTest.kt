package com.lop.devtools.monstera.files

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import kotlin.test.Test

class DeserializerTest {
    @Test
    fun testDeserializer() {
        val gson = GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .registerTypeAdapter(MonsteraRawFile::class.java, MonsteraRawFileTypeAdapter())
            .create()

        // Your class to be serialized
        val myClass = MyClass()
        myClass.additionalKeys = mapOf("key1" to "value1", "key2" to "value2")
        myClass.clazzInner.additionalKeys = mapOf("key1" to "value1", "key2" to "value2")

        var json = gson.toJson(myClass, MonsteraRawFile::class.java)
        println(json)

        myClass.mapTest = mutableMapOf("my_map_test" to MyClass2().apply {
            additionalKeys = mapOf("mapInner" to "check")
        })

        json = gson.toJson(myClass, MonsteraRawFile::class.java)
        println(json)

        myClass.listTest = mutableListOf(MyClass2().apply {
            additionalKeys = mapOf("listInner" to "check")
        })

        json = gson.toJson(myClass, MonsteraRawFile::class.java)
        println(json)
    }

    class MyClass : MonsteraRawFile() {
        @Expose
        var test = "anc"

        @Expose
        @JsonAdapter(MonsteraRawFileTypeAdapter::class)
        var clazzInner = MyClass2()

        @Expose
        @JsonAdapter(MonsteraMapFileTypeAdapter::class)
        var mapTest: MutableMap<String, MyClass2>? = null

        @Expose
        @JsonAdapter(MonsteraListFileTypeAdapter::class)
        var listTest: MutableList<MyClass2>? = null
    }

    class MyClass2 : MonsteraRawFile() {
        @Expose
        var inner = "abc"
    }
}