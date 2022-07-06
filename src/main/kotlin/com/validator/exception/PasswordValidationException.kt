package com.validator.exception

class PasswordValidationException(vararg exception: Exception) : Exception(exception.map { it.message }.joinToString("\n"))
