package me.jiko21.respository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import me.jiko21.dao.TaskDao
import me.jiko21.entity.Task

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: Flow<List<Task>> = taskDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun remove(id: Int) {
        taskDao.delete(id)
    }
}
