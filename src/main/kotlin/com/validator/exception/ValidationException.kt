package com.validator.exception

class ValidationException(vararg exception: Exception) : Exception(exception.map { it.message }.joinToString("\n"))
