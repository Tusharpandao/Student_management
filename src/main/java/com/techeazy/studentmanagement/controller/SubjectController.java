package com.techeazy.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.studentmanagement.entity.Subject;
import com.techeazy.studentmanagement.service.SubjectService;
@RestController
@RequestMapping("/subjects")
public class SubjectController {
	 	@Autowired
	    private SubjectService subjectService;

	    @GetMapping
	    public ResponseEntity<List<Subject>> getAllSubjects() {
	        return ResponseEntity.ok(subjectService.getAllSubjects());
	    }
	    
}
