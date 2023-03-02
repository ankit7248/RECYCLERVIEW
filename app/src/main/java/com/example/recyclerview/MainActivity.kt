package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

// TodoList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(

            Todo("Follow androidDevs",false),
            Todo("Learn about RecycleView",true),
            Todo("Feed my cat",false),
            Todo("Prank my Boss",true),
            Todo("Eat some CURRY",false),
            Todo("Ask my crush out",false),
            Todo("Take a shower",true)
        )

        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter

        // layout manager use for positioning of views in horizontal or vertically
        rvTodos.layoutManager= LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}