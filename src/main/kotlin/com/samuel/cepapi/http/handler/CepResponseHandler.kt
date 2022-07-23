package com.samuel.cepapi.http.handler

import com.samuel.cepapi.log.Logger
import com.samuel.cepapi.log.Logger.Companion.RESPONSE
import com.samuel.cepapi.log.Logger.Companion.RESPONSE_ERROR
import com.samuel.cepapi.util.extensions.fromJson
import retrofit2.Response

inline fun <reified T> Response<T>.response(): T = body()?.also(::logSuccess)
    ?: getError().also(::logError)

inline fun <reified T> Response<T>.getError(): T = errorBody()?.string()
    .fromJson()

fun <T> logSuccess(body: T?) = Logger().info(RESPONSE, body)
fun <T> logError(body: T?) = Logger().info(RESPONSE_ERROR, body)
