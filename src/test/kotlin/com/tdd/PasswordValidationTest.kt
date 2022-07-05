package com.tdd

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PasswordValidationTest {
    private val passwordValidation = PasswordValidation()

    @Test
    fun shouldRaisePasswordLengthException_forPasswordsLessThan8Characters() {
        val exception = assertFailsWith<PasswordValidation.PasswordLengthException> { passwordValidation.validate("1234") }
        assertEquals("Password must be at least 8 characters", exception.message)
    }
}