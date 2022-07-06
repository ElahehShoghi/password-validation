package com.validator

import com.validator.exception.NumberLengthException
import com.validator.exception.PasswordLengthException

class PasswordValidation {

    fun validate(password: String): Boolean {
        if (password.length < 8)
            throw PasswordLengthException()
        val digitCount = password.count() { it.isDigit() }
        if (digitCount < 2)
            throw NumberLengthException()
        return true
    }
}