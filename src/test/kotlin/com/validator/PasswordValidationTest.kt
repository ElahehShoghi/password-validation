package com.validator

import com.validator.exception.NumberLengthException
import com.validator.exception.PasswordLengthException
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PasswordValidationTest {
    private val passwordValidation = PasswordValidation()

    @Test
    fun shouldRaisePasswordLengthException_forPasswordsLessThan8Characters() {
        val exception = assertFailsWith<PasswordLengthException> {
            passwordValidation.validate("1234")
        }
        assertEquals("Password must be at least 8 characters", exception.message)
    }

    @Test
    fun shouldRaiseNumberLengthException_forPasswordContainsLessThan2Numbers() {
        val exception = assertFailsWith<NumberLengthException> {
            passwordValidation.validate("1abcdfgjosup/")
        }
        assertEquals("The password must contain at least 2 numbers", exception.message)
    }
}