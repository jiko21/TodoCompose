package me.jiko21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import me.jiko21.components.TaskLists
import me.jiko21.entity.Task
import me.jiko21.ui.theme.TodoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lists = arrayListOf(
            Task(1, "test1"),
            Task(2, "test2"),
            Task(3, "test3"),
            Task(4, "test4"),
            Task(5, "test5"),
            Task(6, "test6"),
            Task(7, "test7"),
            Task(8, "test8"),
            Task(9, "test9"),
            Task(10, "test10"),
            Task(11, "test11"),
            Task(12, "test12")
        )
        setContent {
            TodoComposeTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Add, contentDescription = "add task")
                        }
                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            TaskLists(lists = lists)
                        }
                    }
                )
            }
        }
    }
}
