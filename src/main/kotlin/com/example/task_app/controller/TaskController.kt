package com.example.task_app.controller

import com.example.task_app.repository.Task
import com.example.task_app.repository.TaskRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/tasks")
class TaskController(
    val repository: TaskRepository
) {
    @GetMapping
    fun list(): List<Task> {
        return repository.list()
    }

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: UUID,
    ): Task? {
        return repository.find(id)
    }

    @PostMapping
    fun create(
        @RequestBody request: CreateRequest
    ): Task {
        val id = UUID.randomUUID()
        val newTask = Task(
            id = id,
            title = request.title,
            content = request.content,
        )
        return repository.create(newTask)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @RequestBody request: CreateRequest,
    ): Task {
        val task = Task(
            id = id,
            title = request.title,
            content = request.content,
        )
        return repository.update(task)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: UUID
    ) {
        repository.delete(id)
    }
}


