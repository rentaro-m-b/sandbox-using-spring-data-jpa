package com.example.task_app.repository

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import java.util.UUID

@Entity
@Table(name = "tasks")
data class TaskEntity(
    @Id val id: UUID,
    val title: String,
    val content: String,
)
