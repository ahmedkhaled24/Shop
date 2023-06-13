package com.hamtary.myapplication.models

data class UserInfo(
    val email: String = "",
    val password: String = "",
    val token: String = "",
    val latitude: String = "",
    val longitude: String = ""
)