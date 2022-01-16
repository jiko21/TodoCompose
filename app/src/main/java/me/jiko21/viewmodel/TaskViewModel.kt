package me.jiko21.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import me.jiko21.entity.Task
import me.jiko21.respository.TaskRepository

class TaskViewModel(private val repository: TaskRepository): ViewModel() {

    val tasks: LiveData<List<Task>> = repository.allTasks.asLiveData()

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }

    fun remove(id: Int) = viewModelScope.launch {
        repository.remove(id)
    }
}

class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}