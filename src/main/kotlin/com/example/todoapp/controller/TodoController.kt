package com.example.todoapp.controller

import com.example.todoapp.entity.Todo
import com.example.todoapp.service.TodoService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/todo"])
class TodoController(private val service: TodoService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllTodo(): ResponseEntity<List<Todo>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findTodoById(@PathVariable(value = "id") id: Long): ResponseEntity<Todo> {
        val todo = service.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok().body(todo)
    }

    @PostMapping(path = ["/"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun saveTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        return ResponseEntity.ok().body(service.saveTodo(todo))
    }
}