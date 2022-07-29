package com.samuel.cepapi.http.retrofit.enum

import com.samuel.cepapi.http.retrofit.ApiHttpRequest
import com.samuel.cepapi.http.retrofit.providers.ApiCepProvider
import com.samuel.cepapi.http.retrofit.providers.ViaCepProvider

enum class ProviderEnum(val type: Class<out ApiHttpRequest>, val baseURL: String) {
    API_CEP(ApiCepProvider::class.java, "https://ws.apicep.com/cep/"),
    VIA_CEP(ViaCepProvider::class.java, "https://viacep.com.br/ws/")
}