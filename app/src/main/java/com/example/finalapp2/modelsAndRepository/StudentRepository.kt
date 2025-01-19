package com.example.finalapp2.modelsAndRepository

object StudentRepository {
    // This is our "in-memory DB"
    val studentsList = mutableListOf<Student>()

    // Sample data if you want some defaults (optional)
    init {
        studentsList.add(Student("Alice",  "111", "0501234567", "Some Address", isChecked = false))
        studentsList.add(Student("Bob",    "222", "0502345678", "Other Address", isChecked = false))
        studentsList.add(Student("Charlie","333", "0503456789", "Another Address", isChecked = false))
    }

    fun addStudent(student: Student) {
        studentsList.add(student)
    }

    fun updateStudent(index: Int, student: Student) {
        // Safely replace the existing Student at that index
        studentsList[index] = student
    }

    fun removeStudent(index: Int) {
        if (index in studentsList.indices) {
            studentsList.removeAt(index)
        }
    }
    fun removeCheckedStudents() {
        studentsList.removeAll { it.isChecked }
    }
    fun getAllStudents(): List<Student> {
        return studentsList
    }
}