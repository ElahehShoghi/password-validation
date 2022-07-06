package com.validator

import com.validator.exception.DigitCountValidationException
import com.validator.exception.LengthValidationException
import com.validator.exception.PasswordValidationException
import com.validator.exception.UppercaseCountValidationException

class PasswordValidation {

    fun validate(password: String){
        val isLengthNotValid = password.length < 8
        val isDigitCountNotValid = password.count { it.isDigit() } < 2
        val isUppercaseCountNotValid = password.count { it.isUpperCase() } < 1
        if (isLengthNotValid || isDigitCountNotValid || isUppercaseCountNotValid)
            throw customException(isLengthNotValid, isDigitCountNotValid, isUppercaseCountNotValid)
    }

    private fun customException(
            isLengthNotValid: Boolean,
            isDigitCountNotValid: Boolean,
            isUppercaseCountNotValid: Boolean
    ): Exception {
        val exceptions = mutableListOf<Exception>()
        if (isLengthNotValid)
            exceptions.add(LengthValidationException())
        if (isDigitCountNotValid)
            exceptions.add(DigitCountValidationException())
        if (isUppercaseCountNotValid)
            exceptions.add(UppercaseCountValidationException())
        return PasswordValidationException(*exceptions.toTypedArray())
    }
}
