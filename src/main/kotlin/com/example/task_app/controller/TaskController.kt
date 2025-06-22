package com.example.task_app.controller

import com.example.task_app.repository.Task
import com.example.task_app.repository.TaskRepository
import com.example.task_app.usecase.TaskUseCase
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
    val repository: TaskRepository,
    val useCase: TaskUseCase,
) {
    @GetMapping
    fun list(): List<Task> {
        return useCase.list()
    }

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: UUID,
    ): Task? {
        return useCase.get(id)
    }

    @PostMapping
    fun create(
        @RequestBody request: CreateRequest
    ): Task {
        return useCase.create(request)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @RequestBody request: UpdateRequest,
    ): Task {
        val task = Task(
            id = id,
            title = request.title,
            content = request.content,
            point = request.point,
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


