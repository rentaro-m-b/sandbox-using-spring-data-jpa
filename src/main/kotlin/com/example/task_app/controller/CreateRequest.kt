package com.example.task_app.controller

data class CreateRequest(
    val title: String,
    val content: String,
    val point: Int,
)
