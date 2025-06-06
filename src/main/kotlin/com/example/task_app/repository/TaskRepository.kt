package com.example.task_app.repository

import org.springframework.data.repository.Repository
import java.util.UUID

interface TaskRepository : Repository<TaskEntity, UUID> {
    fun save(task: TaskEntity): TaskEntity

    fun findById(id: UUID): TaskEntity?
}
