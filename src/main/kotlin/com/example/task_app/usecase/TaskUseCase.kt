package com.example.task_app.usecase

import com.example.task_app.controller.CreateRequest
import com.example.task_app.controller.UpdateRequest
import com.example.task_app.repository.Task
import com.example.task_app.repository.TaskRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskUseCase(
    val repository: TaskRepository
) {
    fun list(): List<Task> {
        return repository.list()
    }

    fun get(id: UUID): Task? {
        return repository.find(id)
    }

    fun create(request: CreateRequest): Task {
        val id = UUID.randomUUID()
        val newTask = Task(
            id = id,
            title = request.title,
            content = request.content,
            point = request.point,
        )
        return repository.create(newTask)
    }

    fun update(
        id: UUID,
        request: UpdateRequest,
    ): Task {
        val task = Task(
            id = id,
            title = request.title,
            content = request.content,
            point = request.point,
        )
        return repository.update(task)
    }

    fun delete(
        id: UUID
    ) {
        repository.delete(id)
    }
}