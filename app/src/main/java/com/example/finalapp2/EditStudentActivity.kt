package com.example.finalapp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapp2.modelsAndRepository.Student
import com.example.finalapp2.modelsAndRepository.StudentRepository

class EditStudentActivity : AppCompatActivity() {
    private var studentIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        studentIndex = intent.getIntExtra("studentIndex", -1)
        if (studentIndex < 0 || studentIndex >= StudentRepository.getAllStudents().size) {
            finish()
            return
        }

        val student = StudentRepository.getAllStudents()[studentIndex]

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val idEditText: EditText = findViewById(R.id.idEditText)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val addressEditText: EditText = findViewById(R.id.addressEditText)
        val saveButton: Button = findViewById(R.id.saveButton)
        val deleteButton: Button = findViewById(R.id.deleteButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)


        // Populate fields with existing student data
        nameEditText.setText(student.name)
        idEditText.setText(student.id)
        phoneEditText.setText(student.phone)
        addressEditText.setText(student.address)

        // Handle Save button click
        saveButton.setOnClickListener {
            val updatedName = nameEditText.text.toString().trim()
            val updatedId = idEditText.text.toString().trim()
            val updatedPhone = phoneEditText.text.toString().trim()
            val updatedAddress = addressEditText.text.toString().trim()

            if (updatedName.isEmpty() || updatedId.isEmpty()) {
                Toast.makeText(this, "Name and ID cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val updatedStudent = Student(
                id = updatedId,
                name = updatedName,
                phone = updatedPhone,
                address = updatedAddress,
                isChecked = student.isChecked
            )
            StudentRepository.updateStudent(studentIndex, updatedStudent)

            val intent = Intent(this, StudentListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // Handle Delete button click
        deleteButton.setOnClickListener {
            StudentRepository.removeStudent(studentIndex)
            val intent = Intent(this, StudentListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
        cancelButton.setOnClickListener {
            val intent = Intent(this, StudentListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
