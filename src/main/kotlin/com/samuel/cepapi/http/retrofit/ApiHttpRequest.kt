package com.samuel.cepapi.http.retrofit

import com.samuel.cepapi.http.retrofit.model.CepResponseDTO
import retrofit2.Call

interface ApiHttpRequest {

    fun get(cep: String) : Call<CepResponseDTO>
}