package com.techeazy.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.studentmanagement.entity.Student;
import com.techeazy.studentmanagement.entity.Subject;
import com.techeazy.studentmanagement.repository.StudentRepository;
import com.techeazy.studentmanagement.repository.SubjectRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;

	public Student saveStudent(Student student) {
	    // Fetch all existing subjects from the database
	    List<Subject> existingSubjects = subjectRepository.findAll();

	    // Create a map to quickly look up existing subjects by name
	    Map<String, Subject> existingSubjectMap = existingSubjects.stream()
	        .collect(Collectors.toMap(Subject::getName, Function.identity()));

	    // Create a list to store the updated subjects
	    List<Subject> updatedSubjects = new ArrayList<>();
	    for (Subject subject : student.getSubjects()) {
	        if (subject.getName() != null) {
	            Subject existingSubject = existingSubjectMap.get(subject.getName());
	            if (existingSubject != null) {
	                // Attach existing subject
	                updatedSubjects.add(existingSubject);
	            } else {
	                // Save new subject and add to the updated list
	                Subject savedSubject = subjectRepository.save(subject);
	                updatedSubjects.add(savedSubject);
	            }
	        }
	    }
	    student.setSubjects(updatedSubjects);

	    // Save the student entity
	    return studentRepository.save(student);
	}


	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

	
}
