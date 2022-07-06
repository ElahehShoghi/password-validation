package com.validator

import com.validator.exception.CapitalLetterException
import com.validator.exception.ValidationException
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PasswordValidationTest {
    private val passwordValidation = PasswordValidation()

    @Test
    fun shouldRaisePasswordLengthException_forPasswordsLessThan8Characters() {
        val exception = assertFailsWith<ValidationException> {
            passwordValidation.validate("1234")
        }
        assertEquals(
            "Password must be at least 8 characters\nPassword must contain at least one capital letter",
            exception.message
        )
    }

    @Test
    fun shouldRaiseNumberLengthException_forPasswordContainsLessThan2Numbers() {
        val exception = assertFailsWith<ValidationException> {
            passwordValidation.validate("1abcdfgjosup/")
        }
        assertEquals(
            "The password must contain at least 2 numbers\n" +
                    "Password must contain at least one capital letter", exception.message
        )
    }

    @Test
    fun `should raise multiple error messages for multiple errors`() {
        val exception = assertThrows<ValidationException> {
            passwordValidation.validate("passwo2")
        }
        assertEquals(
            "Password must be at least 8 characters\nThe password must contain at least 2 numbers\nPassword must contain at least one capital letter",
            exception.message
        )
    }

    @Test
    fun `should raise exception when there are not any capital letters`() {
        val exception = assertThrows<CapitalLetterException> {
            passwordValidation.validate("12sdfghj")
        }
        assertEquals(
            "Password must contain at least one capital letter",
            exception.message
        )
    }
}