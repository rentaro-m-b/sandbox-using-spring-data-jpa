package com.example.task_app.repository

import com.example.task_app.mapper.TaskEntity
import java.util.UUID

data class Task(
    val id: UUID,
    val title: String,
    val content: String,
    val point: Int,
) {
    companion object {
        fun of(entity: TaskEntity): Task {
            return Task(
                id = entity.id,
                title = entity.title,
                content = entity.content,
                point = entity.point,
            )
        }

        fun of(entities: List<TaskEntity>): List<Task> {
            return entities.map { Task.of(it) }
        }
    }
}

