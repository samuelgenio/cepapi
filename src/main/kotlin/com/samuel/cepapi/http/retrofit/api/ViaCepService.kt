package com.samuel.cepapi.http.retrofit.api

import com.samuel.cepapi.http.retrofit.model.CepResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ViaCepService {

    @GET("{cep}/json/")
    @Headers("Accept: application/json", "Content-Type: application/json")
    fun get(@Path("cep") cep: String): Call<CepResponseDTO>

}