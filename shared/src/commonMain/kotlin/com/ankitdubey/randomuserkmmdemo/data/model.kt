package com.ankitdubey.randomuserkmmdemo.data

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserDao(
    val results : List<Person>
)

@Serializable
data class Person(
    val name : Name,
    val gender : String
)
@Serializable
data class Name(
    val first : String,
    val last : String
)
