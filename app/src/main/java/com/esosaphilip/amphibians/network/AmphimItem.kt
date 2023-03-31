package com.esosaphilip.amphibians.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AmphimItem(
    val description: String,

    @SerialName(value = "img_src")
    val imgSrc: String,
    val name: String,
    val type: String
)