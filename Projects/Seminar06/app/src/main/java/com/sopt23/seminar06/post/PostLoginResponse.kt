package com.sopt23.seminar06.post

data class PostLoginResponse(
        val status: Int,
        val message: String,
        val data: LoginData
)

data class LoginData(
        val token: String
)