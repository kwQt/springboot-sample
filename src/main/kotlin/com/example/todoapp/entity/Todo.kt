package com.example.todoapp.entity

import javax.persistence.*

@Entity
@Table(name = "todo")
data class Todo(
        @Id
        @GeneratedValue
        @Column(name = "id")
        var id: Long = 0,

        @Column(name = "title")
        var title: String
)