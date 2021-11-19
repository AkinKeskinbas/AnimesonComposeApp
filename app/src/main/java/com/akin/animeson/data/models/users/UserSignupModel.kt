package com.akin.animeson.data.models.users

data class UserSignupModel(
    val createdAt: String,
    val objectId: String,
    val profilePhoto: ProfilePhoto,
    val sessionToken: String
)