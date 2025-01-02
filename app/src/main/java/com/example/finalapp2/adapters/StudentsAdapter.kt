package com.example.assiment2.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assiment2.databinding.RowStudentBinding
import com.example.assiment2.modelsAndRepository.Student
import com.example.finalapp2.R

class StudentsAdapter(
    private val students: List<Student>,
    private val onRowClick: (Int) -> Unit
) : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = RowStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position], position)
    }

    override fun getItemCount(): Int = students.size

    inner class StudentViewHolder(private val binding: RowStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student, position: Int) {
            // Static image from drawable
            binding.studentImage.setImageResource(R.drawable.ic_student_placeholder)

            binding.tvName.text = student.name
            binding.tvId.text = student.id
            binding.checkBox.isChecked = student.isChecked

            // Toggling check status
            binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
                student.isChecked = isChecked
            }

            // Clicking on entire row -> open details
            binding.root.setOnClickListener {
                onRowClick(position)
            }
        }
    }
}