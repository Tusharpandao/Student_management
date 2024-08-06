package com.techeazy.studentmanagement.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.studentmanagement.entity.Student;
import com.techeazy.studentmanagement.entity.Subject;
import com.techeazy.studentmanagement.repository.SubjectRepository;

@Service
public class SubjectService {
	
	  @Autowired
	    private SubjectRepository subjectRepository;

	    public List<Subject> getAllSubjects() {
	        return subjectRepository.findAll();
	    }

		public List<Subject> addSubjects(List<Subject> subjects) {
			
			  // Fetch all existing subjects from the database
	        List<Subject> existingSubjects = subjectRepository.findAll();

	        // Create a map to quickly look up existing subjects by name
	        Map<String, Subject> existingSubjectMap = existingSubjects.stream()
	                .collect(Collectors.toMap(Subject::getName, Function.identity()));

	        // Filter out subjects that already exist in the database
	        List<Subject> newSubjects = subjects.stream()
	                .filter(subject -> !existingSubjectMap.containsKey(subject.getName()))
	                .collect(Collectors.toList());

	        // Save and return only the new subjects
	        return subjectRepository.saveAll(newSubjects);
		}

		public Subject deleteSubject(Long id) {
		    Subject subject = subjectRepository.findById(id).orElse(null);

		    if (subject != null) {
		        // Remove the subject from each student's list of subjects
		        for (Student student : subject.getStudents()) {
		            student.getSubjects().remove(subject);
		        }
		        subjectRepository.delete(subject);
		        return subject;
		    }
		    return null;
		}

		public Subject getSubjectById(Long id) {
			
			return subjectRepository.findById(id).orElse(null);
		}


}
