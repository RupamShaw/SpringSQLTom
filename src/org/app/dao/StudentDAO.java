package org.app.dao;

import java.util.List;

import org.app.model.Student;

import org.app.model.Student;

public interface StudentDAO {
	Student addStudent(Student Student);

	void removeStudent(int id);

	Student updateStudent(Student Student);

	List<Student> listStudents();

	Student findByIdOrThrowException(int id);

	

	// void delete(AppUser appUser);

	void flush();
}
