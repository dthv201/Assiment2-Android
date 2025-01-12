package com.example.finalapp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val saveButton: Button = findViewById(R.id.saveButton)
        val deleteButton: Button = findViewById(R.id.deleteButton)

        // Populate UI with existing student data
        nameEditText.setText(student.name)
        idEditText.setText(student.id)

        saveButton.setOnClickListener {
            val updatedName = nameEditText.text.toString()
            val updatedId = idEditText.text.toString()

            val updatedStudent = Student(
                id = updatedId,
                name = updatedName,
                phone = student.phone,
                address = student.address,
                isChecked = student.isChecked
            )
            StudentRepository.updateStudent(studentIndex, updatedStudent)
            finish()
        }

        deleteButton.setOnClickListener {
            StudentRepository.removeStudent(studentIndex)
            finish()
        }
    }
}
