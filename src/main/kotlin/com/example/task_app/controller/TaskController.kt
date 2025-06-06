package com.example.task_app.controller

import com.example.task_app.repository.TaskEntity
import com.example.task_app.repository.TaskRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/tasks")
class TaskController(
    val repository: TaskRepository
) {
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: UUID,
    ): TaskEntity? {
        return repository.findById(id)
    }

    @PostMapping
    fun create(
        @RequestBody request: CreateRequest
    ): TaskEntity {
        val id = UUID.randomUUID()
        val newTask = TaskEntity(
            id = id,
            title = request.title,
            content = request.content,
        )
        return repository.save(newTask)
    }
}


