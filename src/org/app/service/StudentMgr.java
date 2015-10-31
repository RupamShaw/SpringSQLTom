package org.app.service;

import java.io.IOException;
import java.util.List;

import org.app.model.Student;
import org.app.model.StudentStatus;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface StudentMgr {
	public List<Student> getAllStudents() throws JsonGenerationException, JsonMappingException, IOException ;
	public Student getStudentbyId(int id);
	public StudentStatus getStudentStatusbyId(int id);
	public Student addStudent(Student student) ;
	public Student updateStudent(Student student);
	
	public void removeStudent(int id);
}
