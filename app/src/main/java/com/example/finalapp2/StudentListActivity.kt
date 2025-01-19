package com.example.finalapp2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalapp2.adapters.StudentsAdapter
import com.example.finalapp2.databinding.ActivityStudentsListBinding
import com.example.finalapp2.modelsAndRepository.StudentRepository

class StudentListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentsListBinding
    private lateinit var adapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = StudentsAdapter(StudentRepository.getAllStudents()) { position ->
            val intent = StudentDetailsActivity.newIntent(this, position)
            startActivity(intent)
        }



        binding.studentsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.studentsRecyclerView.adapter = adapter

        // Handle Add Button
        binding.addButton.setOnClickListener {
            val intent = NewStudentActivity.newIntent(this)
            startActivity(intent)
        }

//        // Handle Delete Button
//        binding.deleteButton.setOnClickListener {
//            StudentRepository.removeCheckedStudents()
//            adapter.notifyDataSetChanged()
//            Toast.makeText(this, "Selected students deleted", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}
