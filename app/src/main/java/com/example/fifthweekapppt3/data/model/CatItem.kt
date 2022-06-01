package com.example.fifthweekapppt3.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatItem(
    @SerialName("id")
    val id: String,
    @SerialName("url")
    val url: String,
    )