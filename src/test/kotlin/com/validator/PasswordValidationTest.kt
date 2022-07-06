package com.validator

import com.validator.exception.PasswordValidationException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PasswordValidationTest {
    private val passwordValidation = PasswordValidation()

    companion object {
        @JvmStatic
        fun invalidPasswordArguments() = listOf(
                Arguments.of("12Sdfgh", "Password must be at least 8 characters"),
                Arguments.of("/1sSd&Wh", "The password must contain at least 2 numbers"),
                Arguments.of("12sdfghj", "Password must contain at least one capital letter"),
                Arguments.of("XX=-0", "Password must be at least 8 characters\nThe password must contain at least 2 numbers"),
                Arguments.of("1234", "Password must be at least 8 characters\nPassword must contain at least one capital letter"),
                Arguments.of("1abcdfgjosup/", "The password must contain at least 2 numbers\nPassword must contain at least one capital letter"),
                Arguments.of("passwo2", "Password must be at least 8 characters\nThe password must contain at least 2 numbers\nPassword must contain at least one capital letter"),
        )
    }

    @ParameterizedTest
    @MethodSource("invalidPasswordArguments")
    fun `should raise exception for invalid passwords`(password: String, exceptionMessage: String) {
        val exception = assertFailsWith<PasswordValidationException> {
            passwordValidation.validate(password)
        }
        assertEquals(exceptionMessage, exception.message)
    }
}