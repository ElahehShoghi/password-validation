package com.tdd

class PasswordValidation {

    fun validate(password: String): Boolean {
        if (password.length < 8)
            throw PasswordLengthException()
        return true
    }

    class PasswordLengthException : Exception("Password must be at least 8 characters")
}
