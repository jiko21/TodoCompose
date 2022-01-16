package me.jiko21.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.jiko21.R
import me.jiko21.entity.Task

@Composable
fun ListItem(task: Task, onDelete: () -> Unit) {
    val padding = 16.dp
    Card(
        backgroundColor = colorResource(R.color.background),
        modifier = Modifier
            .border(
                width = 0.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp),
            )
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = task.content, fontSize = 24.sp)
            Button(
                onClick = onDelete,
                colors = ButtonDefaults.textButtonColors(backgroundColor = colorResource(id = R.color.danger), contentColor = Color.White,)
            ) {
                Text("Delete")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListItem() {
    ListItem(task = Task(1, "服を洗う"), {})
}
