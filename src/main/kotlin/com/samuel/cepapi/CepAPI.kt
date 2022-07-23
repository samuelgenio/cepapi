package com.samuel.cepapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView

@RestController
class CepAPI @Autowired constructor(@Value("\${server.servlet.context-path}") private val basePath: String?) {

    @RequestMapping("/")
    fun redirect(attributes: RedirectAttributes) = RedirectView("${basePath ?: ""}/swagger-ui/index.html")

    @GetMapping("health")
    @ResponseStatus(HttpStatus.OK)
    fun health() = Unit

}