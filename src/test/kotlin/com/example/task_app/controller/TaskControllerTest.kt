package com.example.task_app.controller

import com.example.task_app.repository.Task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals


@SpringBootTest
class TaskControllerTest {
    @Autowired
    private lateinit var target: TaskController

    @Test
    fun `just call get method`() {
        val actual =  target.list()
        val expected = listOf(
            Task(
                id = UUID.fromString("470dc36c-45af-4815-b045-3cae8cb95124"),
                title = "タイトル",
                content = "内容",
            ),
        )
        assertEquals(actual, expected)
    }
}