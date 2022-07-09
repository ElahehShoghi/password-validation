package com.validator

import com.validator.exception.*

class PasswordValidation {

    fun validate(password: String) {
        val isLengthNotValid = password.length < 8
        val isDigitCountNotValid = password.count { it.isDigit() } < 2
        val isUppercaseCountNotValid = password.count { it.isUpperCase() } < 1
        val isSpecialCharacterCountNotValid = password.count { !it.isLetterOrDigit() } < 1
        if (isLengthNotValid || isDigitCountNotValid || isUppercaseCountNotValid || isSpecialCharacterCountNotValid)
            throw customException(isLengthNotValid, isDigitCountNotValid, isUppercaseCountNotValid, isSpecialCharacterCountNotValid)
    }

    private fun customException(
            isLengthNotValid: Boolean,
            isDigitCountNotValid: Boolean,
            isUppercaseCountNotValid: Boolean,
            isSpecialCharacterCountNotValid: Boolean
    ): Exception {
        val exceptions = mutableListOf<Exception>()
        if (isLengthNotValid)
            exceptions.add(LengthValidationException())
        if (isDigitCountNotValid)
            exceptions.add(DigitCountValidationException())
        if (isUppercaseCountNotValid)
            exceptions.add(UppercaseCountValidationException())
        if (isSpecialCharacterCountNotValid)
            exceptions.add(SpecialCharactersCountNotValidationException())
        return PasswordValidationException(*exceptions.toTypedArray())
    }
}
