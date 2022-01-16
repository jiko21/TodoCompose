package me.jiko21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import me.jiko21.components.TaskCreateDialog
import me.jiko21.components.TaskLists
import me.jiko21.entity.Task
import me.jiko21.ui.theme.TodoComposeTheme
import me.jiko21.viewmodel.TaskViewModel
import me.jiko21.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    private val taskViewModel: TaskViewModel by viewModels {
        TaskViewModelFactory((application as TaskApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TodoComposeTheme {
                Container(taskViewModel)
            }
        }
    }
}

@Composable
fun Container(viewModel: TaskViewModel) {

    var isCreateModalOpen by remember {
        mutableStateOf(false)
    }

    val lists = viewModel.tasks.observeAsState(arrayListOf())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                contentColor = Color.White,
                onClick = { isCreateModalOpen = true }) {
                Icon(Icons.Filled.Add, contentDescription = "add task")
            }
        },
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                lists.value?.let {
                    TaskLists(lists = lists.value, onDelete = {id ->
                        viewModel.remove(id)
                    })
                }
                TaskCreateDialog(isCreateModalOpen,
                    onDismiss = { isCreateModalOpen = false },
                    onSubmit = { task ->
                        isCreateModalOpen = false
                        viewModel.insert(task)
                    },
                    onCancel = { isCreateModalOpen = false },
                )
            }
        }
    )
}
