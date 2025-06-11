package com.example.task_app.repository

import com.example.task_app.mapper.TaskEntity
import com.example.task_app.mapper.TaskMapper
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class TaskRepository(
    val mapper: TaskMapper
) {
    fun list(): List<Task> {
        return Task.of(mapper.findAll())
    }

    fun find(id: UUID): Task {
        return Task.of(mapper.findById(id))
    }

    fun create(newTask: Task): Task {
        val entity = TaskEntity.of(newTask)
        return Task.of(mapper.save(entity))
    }

    fun update(task: Task): Task {
        val entity = TaskEntity.of(task)
        return Task.of(mapper.save(entity))
    }

    fun delete(id: UUID) {
        mapper.deleteById(id)
    }
}
