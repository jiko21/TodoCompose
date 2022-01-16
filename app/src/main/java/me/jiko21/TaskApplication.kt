package me.jiko21

import android.app.Application
import me.jiko21.infrastructure.AppDatabase
import me.jiko21.respository.TaskRepository

class TaskApplication : Application() {
    val database by lazy { AppDatabase.getDatabases(this) }
    val repository by lazy { TaskRepository(database.taskDao()) }
}