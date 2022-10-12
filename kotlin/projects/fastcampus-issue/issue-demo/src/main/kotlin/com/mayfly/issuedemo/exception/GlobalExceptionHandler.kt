package com.mayfly.issuedemo.exception

import com.auth0.jwt.exceptions.TokenExpiredException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(exc: ServerException): ErrorResponse {
        logger.error { exc.message }

        return ErrorResponse(code= exc.code, message = exc.message)
    }

    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(exc: TokenExpiredException): ErrorResponse {
        logger.error { exc.message }

        return ErrorResponse(code= 401, message = "Token Expired Error")
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exc: Exception): ErrorResponse {
        logger.error { exc.message }

        return ErrorResponse(code= 500, message = "Internal Server Error")
    }
}