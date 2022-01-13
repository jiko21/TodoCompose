package me.jiko21.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.jiko21.entity.Task

@Composable
fun ListItem(task: Task) {
    Row {
       Text(text = task.content)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListItem() {
    ListItem(task = Task(1, "服を洗う"))
}
