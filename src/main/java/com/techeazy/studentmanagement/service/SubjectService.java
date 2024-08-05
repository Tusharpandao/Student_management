package com.techeazy.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.studentmanagement.entity.Subject;
import com.techeazy.studentmanagement.repository.SubjectRepository;

@Service
public class SubjectService {
	
	  @Autowired
	    private SubjectRepository subjectRepository;

	    public List<Subject> getAllSubjects() {
	        return subjectRepository.findAll();
	    }

}
