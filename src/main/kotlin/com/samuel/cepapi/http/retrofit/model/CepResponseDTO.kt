package com.samuel.cepapi.http.retrofit.model

import com.google.gson.annotations.JsonAdapter
import com.samuel.cepapi.http.adapter.IntegerAdapter
import io.swagger.annotations.ApiModelProperty

data class CepResponseDTO(
    @ApiModelProperty(example = "01153-000")
    val cep: String,
    @ApiModelProperty(example = "Rua Vitorino Carmilo")
    val logradouro: String,
    @ApiModelProperty(example = "de 456/457 a 899/900")
    val complemento: String,
    @ApiModelProperty(example = "Barra Funda")
    val bairro: String,
    @ApiModelProperty(example = "São Paulo")
    val localidade: String,
    @ApiModelProperty(example = "SP")
    val uf: String,
    @JsonAdapter(IntegerAdapter::class)
    @ApiModelProperty(example = "3550308")
    val ibge: Int,
    @ApiModelProperty(example = "1004")
    val gia: String,
    @ApiModelProperty(example = "11")
    val ddd: String,
    @JsonAdapter(IntegerAdapter::class)
    @ApiModelProperty(example = "7107")
    val siafi: Int
)