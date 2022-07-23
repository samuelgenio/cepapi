package com.samuel.cepapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@SpringBootApplication
class CepApiApplication

fun main(args: Array<String>) {
	runApplication<CepApiApplication>(*args)
}