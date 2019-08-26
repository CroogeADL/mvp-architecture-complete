package com.example.model.joke

import com.google.gson.annotations.SerializedName

data class ChuckNorrisJokeResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("joke") val joke: String
)