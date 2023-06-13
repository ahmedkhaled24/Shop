package com.hamtary.myapplication.models

data class Profile(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val image: String,
    val points: Int,
    val credit: Int,
    val token: String
)
