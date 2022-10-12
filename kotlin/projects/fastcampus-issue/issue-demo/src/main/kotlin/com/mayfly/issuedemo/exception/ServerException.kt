package com.mayfly.issuedemo.exception

import java.lang.RuntimeException

sealed class ServerException(
    val code: Int,
    override val message: String,
): RuntimeException(message)

data class NotFoundException(
    override val message: String,
): ServerException(404, message)

data class UnauthorizedException(
    override val message: String = "unauthorized"
): ServerException(401, message)