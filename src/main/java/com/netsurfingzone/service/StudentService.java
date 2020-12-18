package com.netsurfingzone.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.netsurfingzone.entity.Student;

@Component
public interface StudentService {

	public Student save(Student student);

	public List<Student> getStudents();
}
