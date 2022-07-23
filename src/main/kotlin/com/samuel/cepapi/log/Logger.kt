package com.samuel.cepapi.log

import com.samuel.cepapi.log.model.LogDTO
import com.samuel.cepapi.util.extensions.toJson
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class Logger {

    companion object {
        const val RESPONSE = "Success request"
        const val RESPONSE_ERROR = "Error request"
        const val CEP_CONSULT = "consulting %s at %tc"
    }

    private val logger = KotlinLogging.logger {}

    fun info(message: String, payload: Any? = null) {
        logger.info(LogDTO(message, payload).toJson())
    }

    fun error(t:Throwable?, message: () -> Any?) {
        logger.error(t, message);
    }

}