package me.jiko21.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import me.jiko21.entity.Task
import org.junit.Rule
import org.junit.Test

class TaskListsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldCorrectlyRender() {

        val lists = arrayListOf(
            Task(1, "test1"),
            Task(2, "test2"),
            Task(3, "test3")
        )

        composeTestRule.setContent {
            TaskLists(lists = lists)
        }
        lists.forEach { task ->
            composeTestRule.onNodeWithText(task.content)
        }
    }
}