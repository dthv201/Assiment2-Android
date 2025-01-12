package com.example.finalapp2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapp2.modelsAndRepository.StudentRepository

class StudentDetailsActivity : AppCompatActivity() {
    private var studentIndex: Int = -1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentIndex = intent.getIntExtra("studentIndex", -1)
        if (studentIndex < 0 || studentIndex >= StudentRepository.getAllStudents().size) {
            // Handle invalid index (optional)
            finish()
            return
        }

        val student = StudentRepository.getAllStudents()[studentIndex]

        // Populate UI with student details
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val idTextView: TextView = findViewById(R.id.idTextView)
        val photoImageView: ImageView = findViewById(R.id.photoImageView)

        nameTextView.text = student.name
        idTextView.text = student.id
        photoImageView.setImageResource(R.drawable.ic_student_placeholder)

        val editButton: Button = findViewById(R.id.editButton)
        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentIndex", studentIndex)
            startActivity(intent)
        }
    }
}
