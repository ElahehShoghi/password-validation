package com.validator

import com.validator.exception.NumberLengthException
import com.validator.exception.PasswordLengthException
import com.validator.exception.ValidationException

class PasswordValidation {

    fun validate(password: String): Boolean {
        val digitCount = password.count { it.isDigit() }
        if (password.length < 8 && digitCount < 2)
            throw ValidationException()
        else if (password.length < 8)
            throw PasswordLengthException()
        else if (digitCount < 2)
            throw NumberLengthException()
        return true
    }
}
