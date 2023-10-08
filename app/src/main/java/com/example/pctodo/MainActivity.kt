package com.example.pctodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pctodo.databinding.ActivityMainBinding
import com.example.todolist.TodoAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var mainbind: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbind = ActivityMainBinding.inflate(layoutInflater)
        todoAdapter = TodoAdapter(mutableListOf())
        setContentView(mainbind.root)
        mainbind.rvtodoitems.adapter = todoAdapter
        mainbind.rvtodoitems.layoutManager = LinearLayoutManager(this)

        mainbind.adbaddbutton.setOnClickListener{
            val todoTitle = mainbind.etedit.text.toString()
            if(todoTitle.isNotEmpty())
            {
                val TODO = todolist(todoTitle)
                todoAdapter.addTodo(TODO)
                mainbind.etedit.text.clear()

            }
        }

        mainbind.dldeletebutton.setOnClickListener{
            todoAdapter.deleteDoneTodos()
        }
    }
}