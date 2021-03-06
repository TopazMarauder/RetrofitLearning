package com.example.retrofitlearning.models

data class CategoryResponse(
    val count: Int,
    val data: List<Data>,
    val error: Boolean
)

data class Data(
    val __v: Int,
    val _id: String,
    val catDescription: String,
    val catId: Int,
    val catImage: String,
    val catName: String,
    val position: Int,
    val slug: String,
    val status: Boolean
)

