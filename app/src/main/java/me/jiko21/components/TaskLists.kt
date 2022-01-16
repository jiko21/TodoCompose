package me.jiko21.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.jiko21.entity.Task

@Composable
fun TaskLists(lists: List<Task>, onDelete: (id: Int) -> Unit) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp),) {
        items(lists) { task ->
            ListItem(task = task, onDelete = {
                task.id?.let { it -> onDelete(it)}
            })
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
    TaskLists(lists = lists, onDelete = {})
}
