Below is a simple README.md template you can place in your repository. Feel free to modify it and add any additional details that are relevant to your project.
Assignment 2 – Students App

A basic Android application in Kotlin for managing a list of students. This includes adding new students, displaying them in a RecyclerView, and editing their details.
Features

    Student List
        Displays the entire list of students with their name, ID, and a checkbox to mark each student.
        Implemented using RecyclerView.

    Add New Student
        A form to add a new student with the following details:
            Name
            Student ID
            Phone
            Address
            Checked status
        Persists data in an in-memory repository (lost when the app closes).

    Edit Student (Optional / In progress)
        Screen to edit or delete an existing student (all fields can be updated, including ID).
        Also updates the in-memory repository.

    Student Details (Optional / In progress)
        Shows a single student’s information in more detail.

Screens

    StudentListActivity
        Displays the list of students (name, ID, checkbox, and static image).
        Tapping “Add” button opens NewStudentActivity.

    NewStudentActivity
        A form with EditText fields for the student’s name, ID, phone, and address, plus a checkbox.
        Tapping “Save” adds the new student to the repository and returns to the list screen.

    (Planned) StudentDetailsActivity
        Displays more comprehensive details for a selected student.
        (Currently stubs or not implemented.)

    (Planned) EditStudentActivity
        Allows editing or deleting an existing student.
        (Currently stubs or not implemented.)

Technology & Libraries

    Kotlin: Core language for Android development.
    AndroidX: Using modern Android libraries (RecyclerView, ConstraintLayout, etc.).
    ViewBinding: For simplified view references in Activities.
    In-Memory Repository: A simple Kotlin object that holds the student list in memory.
    RecyclerView: To display the students in a scrollable list.

How to Run

    Clone the repository:

    git clone https://github.com/dthv201/Assiment2-Android.git

    Open the project in Android Studio.
    Build & Run on an emulator or physical device.
        Note: The in-memory data will reset every time you close or relaunch the app.

Contributing

    Fork the repository and clone to your local machine.
    Create a new branch for your feature or bug fix.
    Commit your changes and push to your fork.
    Open a Pull Request detailing your changes.
