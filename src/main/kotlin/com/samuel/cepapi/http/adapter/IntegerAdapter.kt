package com.samuel.cepapi.http.adapter

import com.google.gson.*
import java.lang.reflect.Type

class IntegerAdapter : JsonDeserializer<Int>, JsonSerializer<Int> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Int? =
        json?.asString?.takeIf(String::isNotEmpty)?.toInt()

    override fun serialize(src: Int?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement =
        JsonPrimitive(src)

}