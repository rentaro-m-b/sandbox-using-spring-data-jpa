package com.example.task_app.repository

import com.example.task_app.mapper.TaskEntity
import com.example.task_app.mapper.TaskMapper
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import java.util.UUID
import javax.sql.DataSource
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
class TaskRepositoryTest {
    @Autowired
    private lateinit var target: TaskRepository

    @Autowired
    private lateinit var dataSource: DataSource

    private val jdbc by lazy { JdbcTemplate(dataSource) }

    companion object {

        private val postgres = PostgreSQLContainer("postgres:17-alpine")

        @JvmStatic
        @DynamicPropertySource
        fun registerDataSourceProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgres::getJdbcUrl)
            registry.add("spring.datasource.username", postgres::getUsername)
            registry.add("spring.datasource.password", postgres::getPassword)
        }

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            postgres.start()
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            postgres.stop()
        }
    }

    @BeforeEach
    fun beforeEach() {
        jdbc.update(
            """
            INSERT INTO tasks (id, title, content, point) VALUES (?, ?, ?, ?)
            """.trimIndent(),
            UUID.fromString("470dc36c-45af-4815-b045-3cae8cb95124"),
            "タイトル",
            "内容",
            1
        )
    }

    @AfterEach
    fun afterEach() {
        jdbc.execute("DELETE FROM tasks")
    }

    @Test
    fun `just call findAll method`() {
        val actual =  target.list()
        val expected = listOf(
            Task(
                id = UUID.fromString("470dc36c-45af-4815-b045-3cae8cb95124"),
                title = "タイトル",
                content = "内容",
                point = 1,
            ),
        )
        assertEquals(expected, actual)
    }
}