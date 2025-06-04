package com.example.task_app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController {
    @GetMapping
    fun get(): String {
        return "hello world!"
    }
}