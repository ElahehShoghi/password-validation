package com.validator

import com.validator.exception.CapitalLetterException
import com.validator.exception.NumberLengthException
import com.validator.exception.PasswordLengthException
import com.validator.exception.ValidationException

class PasswordValidation {

    fun validate(password: String): Boolean {
        val lengthFlag = password.length > 7
        val digitCountFlag = password.count { it.isDigit() } > 1
        val uppercaseCountFlag = password.count { it.isUpperCase() } > 0
        if (!lengthFlag && !digitCountFlag && !uppercaseCountFlag)
            throw ValidationException(PasswordLengthException(), NumberLengthException(), CapitalLetterException())
        else if (!lengthFlag && !digitCountFlag)
            throw ValidationException(PasswordLengthException(), NumberLengthException())
        else if (!digitCountFlag && !uppercaseCountFlag)
            throw ValidationException(NumberLengthException(), CapitalLetterException())
        else if (!lengthFlag && !uppercaseCountFlag)
            throw ValidationException(PasswordLengthException(), CapitalLetterException())
        else if (!lengthFlag)
            throw PasswordLengthException()
        else if (!digitCountFlag)
            throw NumberLengthException()
        else if (!uppercaseCountFlag)
            throw CapitalLetterException()
        return true
    }
}
