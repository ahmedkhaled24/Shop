package com.hamtary.myapplication.network.data

import com.google.gson.*
import java.lang.reflect.Type


internal class Deserializer<T> : JsonDeserializer<MyResponse<T>> {
    @Throws(JsonParseException::class)
    override fun deserialize(je: JsonElement, type: Type, jdc: JsonDeserializationContext): MyResponse<T> {
        val content = je.asJsonObject
        // Deserialize it. You use a new instance of Gson to avoid infinite recursion to this deserializer
        return Gson().fromJson(content, type)
    }
}