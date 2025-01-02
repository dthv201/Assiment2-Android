package com.example.finalapp2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.finalapp2.modelsAndRepository.Student
import com.example.finalapp2.modelsAndRepository.StudentRepository
import com.example.finalapp2.databinding.ActivityNewStudentBinding

class NewStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancel.setOnClickListener {
            finish() // closes the current Activity and goes back
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val id = binding.etId.text.toString()
            val phone = binding.etPhone.text.toString()
            val address = binding.etAddress.text.toString()
            val checked = binding.checkBoxNewStudent.isChecked

            // Create new student with the given data
            val newStudent = Student(
                id = id,
                name = name,
                phone = phone,
                address = address,
                isChecked = checked
            )

            // Add to "database"
            StudentRepository.addStudent(newStudent)

            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NewStudentActivity::class.java)
        }
    }
}