package com.samuel.cepapi.http.retrofit.api

import com.samuel.cepapi.http.RetrofitBuilder
import com.samuel.cepapi.http.handler.response
import com.samuel.cepapi.http.retrofit.model.CepResponseDTO
import com.samuel.cepapi.log.Logger
import com.samuel.cepapi.log.Logger.Companion.CEP_CONSULT
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@Api("CEP API")
@RestController
@RequestMapping("api/cep")
class ViaCepAPI @Autowired constructor(
        private val builder: RetrofitBuilder,
        private val logger: Logger){

    @GetMapping("{cep}")
    @ApiOperation("Busca informações do CEP")
    fun get(@PathVariable("cep") cep: String): CepResponseDTO? {
        logger.info(CEP_CONSULT.format(cep, Date()))
        return builder.build<ViaCepService>("https://viacep.com.br/ws/").get(cep)
            .execute()
            .response()
    }

}