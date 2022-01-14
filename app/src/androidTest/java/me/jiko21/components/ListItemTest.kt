package me.jiko21.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import me.jiko21.entity.Task
import org.junit.Rule
import org.junit.Test

class ListItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldCorrectlyRender() {

        val task = Task(1, "sample text")
        composeTestRule.setContent {
            ListItem(task = task)
        }

        composeTestRule.onNodeWithText(task.content)
    }
}