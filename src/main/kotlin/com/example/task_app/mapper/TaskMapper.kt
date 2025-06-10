package com.example.task_app.mapper

import org.springframework.data.repository.Repository
import java.util.UUID

interface TaskMapper: Repository<TaskEntity, UUID> {
    fun findById(id: UUID): TaskEntity
    fun save(task: TaskEntity): TaskEntity
}