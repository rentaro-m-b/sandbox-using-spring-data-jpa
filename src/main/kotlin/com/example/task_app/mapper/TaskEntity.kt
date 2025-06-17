package com.example.task_app.mapper

import com.example.task_app.repository.Task
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tasks")
data class TaskEntity(
    @Id val id: UUID,
    val title: String,
    val content: String,
    val point: Int,
) {
    companion object {
        fun of(model: Task): TaskEntity {
            return TaskEntity(
                id = model.id,
                title = model.title,
                content = model.content,
                point = model.point,
            )
        }
    }
}