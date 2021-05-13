package com.example.retrofitlearning.models

class PostResponse : ArrayList<PostResponseItem>()

data class PostResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

data class PostGenerator(
    val body: String,
    val title: String,
    val userId: Int
)
