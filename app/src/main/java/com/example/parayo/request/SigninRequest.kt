package com.example.parayo.request

import android.util.Patterns
import com.example.parayo.common.Prefs
import java.util.regex.Pattern

class SigninRequest(
    val email : String?,
    val password : String?,
    val fcmToken : String? = Prefs.fcmToken
) {

    fun isNotValidEmail() =
        email.isNullOrBlank()
                || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotValidPassword() =
            password.isNullOrBlank() || password.length !in 8..20

}