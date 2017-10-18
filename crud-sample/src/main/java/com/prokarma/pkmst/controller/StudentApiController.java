package com.prokarma.pkmst.controller;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.pkmst.model.Student;
import com.prokarma.pkmst.model.StudentRepository;
/**
 * Api implemention
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.PkmstServerCodegen", date = "2017-10-13T15:19:53.170Z")

@RestController
public class StudentApiController implements StudentApi {
	
    private final ObjectMapper objectMapper;
    @Autowired
    public StudentApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    
    @Autowired
	private StudentRepository studentRepository;
    
    @RequestMapping(method=RequestMethod.GET, value="/student/{id}")
    public ResponseEntity<Student> studentInfo(@ApiParam(value = "Get Student information",required=true ) @PathVariable Long id,
            @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
		Student student = this.studentRepository.findOne(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
    
    public ResponseEntity<String> createStudent(@ApiParam(value = "Created Student object" ,required=true )   @RequestBody Student student,
            @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	this.studentRepository.save(student);
    	return new ResponseEntity<>("Student Registered Successfully",HttpStatus.OK);
    }
    
    public ResponseEntity<List<Student>> allStudents() throws Exception {    	
    	return new ResponseEntity<>(this.studentRepository.findAll(),HttpStatus.OK);
    }
    
    public ResponseEntity<String> updateStudent(@ApiParam(value = "Update Student Info" ,required=true )   @RequestBody Student student,
            @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	this.studentRepository.save(student);    	
    	return new ResponseEntity<>("Modified Student Information Successfully",HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@ApiParam(value = "Delete Student information",required=true ) @PathVariable Long id,
            @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
		this.studentRepository.delete(id);
		return new ResponseEntity<>("Student information delete successfully.", HttpStatus.OK);
	}


}
