package com.example.todo_list_kotlin

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) :  AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "todo.db"
    ).build()

    var newTodo: String? = null

    val todos = db.todoDao().getAll()

//    var todos: LiveData<List<Todo>>
//    init {
//        todos = getAll()
//    }

//    val todos: LiveData<List<Todo>>
//        get() {
//            return    getAll()
//        }


//   fun getAll() : LiveData<List<Todo>> {
//        return db.todoDao().getAll()
//    }

    fun insert(todo: String?) {
        if(todo == null) return

        viewModelScope.launch(Dispatchers.IO) {
            db.todoDao().insert(Todo(todo))
        }
    }
}