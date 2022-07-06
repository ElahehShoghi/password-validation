package com.validator

import com.validator.exception.DigitCountValidationException
import com.validator.exception.LengthValidationException
import com.validator.exception.PasswordValidationException
import com.validator.exception.UppercaseCountValidationException

class PasswordValidation {

    fun validate(password: String): Boolean {
        val isLengthValid = password.length > 7
        val isDigitCountValid = password.count { it.isDigit() } > 1
        val isUppercaseCountValid = password.count { it.isUpperCase() } > 0
        if (isLengthValid && isDigitCountValid && isUppercaseCountValid)
            return true
        throw exception(isLengthValid, isDigitCountValid, isUppercaseCountValid)
    }

    private fun exception(
        isLengthValid: Boolean,
        isDigitCountValid: Boolean,
        isUppercaseCountValid: Boolean
    ): Exception {
        if (!isLengthValid && !isDigitCountValid && !isUppercaseCountValid)
            return PasswordValidationException(LengthValidationException(), DigitCountValidationException(), UppercaseCountValidationException())
        else if (!isLengthValid && !isDigitCountValid)
            return PasswordValidationException(LengthValidationException(), DigitCountValidationException())
        else if (!isDigitCountValid && !isUppercaseCountValid)
            return PasswordValidationException(DigitCountValidationException(), UppercaseCountValidationException())
        else if (!isLengthValid && !isUppercaseCountValid)
            return PasswordValidationException(LengthValidationException(), UppercaseCountValidationException())
        else if (!isLengthValid)
            return LengthValidationException()
        else if (!isDigitCountValid)
            return DigitCountValidationException()
        else if (!isUppercaseCountValid)
            return UppercaseCountValidationException()
        return Exception()
    }
}
