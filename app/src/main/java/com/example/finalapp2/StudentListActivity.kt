package com.example.assiment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.assiment2.adapters.StudentsAdapter
import com.example.assiment2.modelsAndRepository.StudentRepository
import com.example.finalapp2.databinding.ActivityStudentsListBinding

class StudentListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentsListBinding
    private lateinit var adapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        adapter = StudentsAdapter(StudentRepository.studentsList) { position ->
            // For now, let's just show a quick message instead of opening details
            Toast.makeText(this, "Clicked on position $position", Toast.LENGTH_SHORT).show()

            // If you later implement StudentDetailsActivity, you can restore this:
            // val intent = StudentDetailsActivity.newIntent(this, position)
            // startActivity(intent)
        }
        binding.studentsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.studentsRecyclerView.adapter = adapter

        // FloatingActionButton to create new student
        binding.addButton.setOnClickListener {
            val intent = NewStudentActivity.newIntent(this)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh list (in case something changed)
        adapter.notifyDataSetChanged()
    }
}
