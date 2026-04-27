package com.jayr.mvvm.ui.screens.student_dashboard

import androidx.lifecycle.ViewModel
import com.jayr.mvvm.data.models.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StudentViewModel: ViewModel() {

   // state
    private val _student = MutableStateFlow<Student>(Student())
    val student = _student.asStateFlow()

    // methods
    fun createStudent(name:String, age:Int ){
        _student.value = Student(name = name, age = age)
    }
}