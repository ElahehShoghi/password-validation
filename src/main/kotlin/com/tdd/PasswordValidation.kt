package com.tdd

class PasswordValidation {

    fun validate(password: String): Boolean {
        if (password.length < 8)
            throw PasswordLengthException()
        val digitCount = password.count() { it.isDigit() }
        if (digitCount < 2)
            throw NumberLengthException()
        return true
    }

    class PasswordLengthException : Exception("Password must be at least 8 characters")

    class NumberLengthException : Exception("The password must contain at least 2 numbers")
}
