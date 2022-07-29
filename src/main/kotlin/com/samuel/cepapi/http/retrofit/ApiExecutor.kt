package com.samuel.cepapi.http.retrofit

import com.samuel.cepapi.http.RetrofitBuilder
import com.samuel.cepapi.http.handler.response
import com.samuel.cepapi.http.retrofit.enum.ProviderEnum
import com.samuel.cepapi.http.retrofit.model.CepResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApiExecutor @Autowired constructor(
        private val retrofitBuilder: RetrofitBuilder) {

    fun execute(cep: String): CepResponseDTO? {
        ProviderEnum.values().forEach { runCatching{ return callRequest(it, cep) } }?.let{ throw Exception("All API inválids") }
    }

    private fun callRequest(provider: ProviderEnum, cep: String): CepResponseDTO {
        return retrofitBuilder.builder(provider.baseURL).create(provider.type).get(cep).execute().response()
    }
}