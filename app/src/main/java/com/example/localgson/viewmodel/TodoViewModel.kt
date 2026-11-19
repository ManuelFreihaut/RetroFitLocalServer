package com.example.localgson.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localgson.model.Todo
import com.example.localgson.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> get() = _todos

    fun fetchTodos() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTodos()
                _todos.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}