package me.jiko21.components

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.jiko21.entity.Task

@Composable
fun TaskLists(lists: List<Task>) {
    LazyColumn {
        items(lists) { task ->
            ListItem(task = task)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskLists() {
    val lists = arrayListOf(
        Task(1, "test1"),
        Task(2, "test2"),
        Task(3, "test3")
    )
    TaskLists(lists = lists)
}
