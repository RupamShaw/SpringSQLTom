package org.app.dao;

import java.io.IOException;
import java.util.List;

import org.app.model.Student;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.app.model.Student;

public interface StudentDAO {
	Student addStudent(Student Student);

	void removeStudent(int id);

	Student updateStudent(Student Student);

	List<Student> listStudents() throws JsonGenerationException, JsonMappingException, IOException;

	Student findByIdOrThrowException(int id);

	

	// void delete(AppUser appUser);

	void flush();
}
