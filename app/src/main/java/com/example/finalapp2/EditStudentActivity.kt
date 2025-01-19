
package com.example.finalapp2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        // Fetch the student index from the intent
        studentIndex = intent.getIntExtra(EXTRA_STUDENT_INDEX, -1)
        Log.d("EditStudentActivity", "Received studentIndex: $studentIndex")

        if (studentIndex < 0 || studentIndex >= StudentRepository.getAllStudents().size) {
            finish()
            return
        }

        // Fetch the student details
        val student = StudentRepository.getAllStudents()[studentIndex]
        findViewById<EditText>(R.id.nameEditText).setText(student.name)
        findViewById<EditText>(R.id.idEditText).setText(student.id)
        findViewById<EditText>(R.id.phoneEditText).setText(student.phone)
        findViewById<EditText>(R.id.adressEditText).setText(student.address)

        // Save Button Logic
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val updatedName = findViewById<EditText>(R.id.nameEditText).text.toString()
            val updatedId = findViewById<EditText>(R.id.idEditText).text.toString()
            val updatedPhone = findViewById<EditText>(R.id.phoneEditText).text.toString()
            val updatedAddress = findViewById<EditText>(R.id.adressEditText).text.toString()

            val updatedStudent = Student(
                id = updatedId,
                name = updatedName,
                phone = updatedPhone,
                address = updatedAddress,
                isChecked = student.isChecked // Preserve existing check status
            )

            StudentRepository.updateStudent(studentIndex, updatedStudent)
            finish() // Return to previous activity
        }

        // Delete Button Logic
        findViewById<Button>(R.id.deleteButton).setOnClickListener {
            StudentRepository.removeStudent(studentIndex)
            finish()
        }
    }

    companion object {
        private const val EXTRA_STUDENT_INDEX = "com.example.finalapp2.student_index"

        fun newIntent(context: Context, studentIndex: Int): Intent {
            return Intent(context, EditStudentActivity::class.java).apply {
                putExtra(EXTRA_STUDENT_INDEX, studentIndex)
            }
        }
    }
}
