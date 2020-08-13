package com.example.todoapp.service

import com.example.todoapp.entity.Todo
import com.example.todoapp.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(private val repository: TodoRepository) {
    fun findAll(): List<Todo> {
        return repository.findAll()
    }

    fun saveTodo(todo: Todo): Todo {
        return repository.save(todo)
    }

    fun findById(id: Long): Todo? {
        return repository.findById(id).orElse(null)
    }
}