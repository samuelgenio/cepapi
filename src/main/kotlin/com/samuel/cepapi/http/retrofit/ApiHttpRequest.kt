package com.samuel.cepapi.http.retrofit

import com.samuel.cepapi.http.retrofit.model.CepResponseDTO

interface ApiHttpRequest {

    fun load() : CepResponseDTO
}