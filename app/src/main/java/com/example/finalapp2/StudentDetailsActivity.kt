package com.example.finalapp2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapp2.modelsAndRepository.StudentRepository

class StudentDetailsActivity : AppCompatActivity() {
    private var studentIndex: Int = -1

//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentIndex = intent.getIntExtra(EXTRA_STUDENT_INDEX, -1)
        if (studentIndex < 0 || studentIndex >= StudentRepository.getAllStudents().size) {
            finish()
            return
        }

        val student = StudentRepository.getAllStudents()[studentIndex]

        // Update the UI
        findViewById<ImageView>(R.id.photoImageView).setImageResource(R.drawable.ic_student_placeholder)
        findViewById<TextView>(R.id.idTextView).text = "ID: ${student.id}"
        findViewById<TextView>(R.id.nameTextView).text = "Name: ${student.name}"
        findViewById<TextView>(R.id.phoneTextView).text = "Phone: ${student.phone}"
        findViewById<TextView>(R.id.adressTextView).text = "Adress: ${student.address}"


        findViewById<CheckBox>(R.id.student_details_checkbox).isChecked = student.isChecked

        val editButton: Button = findViewById(R.id.editButton)
        editButton.setOnClickListener {
            Log.d("StudentDetailsActivity", "Navigating to EditStudentActivity with index: $studentIndex")

            val intent = EditStudentActivity.newIntent(this, studentIndex)
            startActivity(intent)
        }

    }


    companion object {
        private const val EXTRA_STUDENT_INDEX = "com.example.finalapp2.student_index"

        fun newIntent(context: Context, studentIndex: Int): Intent {
            return Intent(context, StudentDetailsActivity::class.java).apply {
                putExtra(EXTRA_STUDENT_INDEX, studentIndex)
            }
        }
    }

}


