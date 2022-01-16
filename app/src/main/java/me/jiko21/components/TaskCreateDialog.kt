package me.jiko21.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import me.jiko21.entity.Task

@Composable
fun TaskCreateDialog(isOpened: Boolean, onDismiss: () -> Unit, onSubmit: (task: Task) -> Unit, onCancel: () -> Unit) {
    var content by remember {
        mutableStateOf("")
    }
    if (isOpened) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Add task to do") },
            text = {
                Column() {
                    OutlinedTextField(
                        value = content,
                        onValueChange = { content = it },
                        label = { Text("What to do?") }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onSubmit(Task(null, content))
                        content = ""
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onCancel
                ) {
                    Text("Cancel")
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskCreateDialog() {
    TaskCreateDialog(true, onDismiss = {}, onCancel = {}, onSubmit = {})
}
