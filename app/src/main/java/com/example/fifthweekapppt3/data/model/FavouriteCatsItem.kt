package com.example.fifthweekapppt3.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class FavouriteCatsItem(
    @SerialName("image_id")
    val image_id: String,
)