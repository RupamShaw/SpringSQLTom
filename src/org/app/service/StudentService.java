/**
 * 
 */
package org.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.app.dao.StudentDAO;

import org.app.dao.StudentJPADAO;

import org.app.exception.DataNotFoundException;
import org.app.model.Student;
import org.app.model.StudentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author Dell
 *
 */
@Service("studentMgr")

public class StudentService implements StudentMgr{
	//@Resource
	 @Autowired
	private StudentDAO studentDao;

	


	String className = getClass().getSimpleName();

	public StudentService() {
		System.out.println("StudentService constructor()");

	}

	@Override
	public List<Student> getAllStudents() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");
		List<Student> lStudent = studentDao.listStudents();
		System.out.println(className + "." + methodName + "() "+"list of student size is"+lStudent.size());
		return lStudent;
	}

	/** 
	 * without exception public Student getStudentbyId(long id) {
	 * 
	 * return students.get(id); }
	 */
	@Override
	public Student getStudentbyId(int id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");
		return studentDao.findByIdOrThrowException(id);

	}
	@Override
	public StudentStatus getStudentStatusbyId(int id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");
		StudentStatus ss = new StudentStatus(true);
		try{
		Student student=studentDao.findByIdOrThrowException(id);
		
		if (student == null) {
			ss.setStatus(false);
		}
		}catch(EmptyResultDataAccessException e){
			ss.setStatus(false);
		}
		return ss;

	}
	@Override
	@Transactional
	public Student addStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");
		student=studentDao.addStudent(student);
		studentDao.flush();
		return student;

	}
	@Override
	@Transactional
	public Student updateStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");

	if(student!=null){
		System.out.println("studentservice update if not null");
		student=studentDao.updateStudent(student);
		studentDao.flush();
		return student;
	}else{
		System.out.println("studentservice update else null");
		throw new EmptyResultDataAccessException("student with id wasn't found.", 1);
	}
	}
	@Override
	@Transactional
	public void removeStudent(int id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");
		studentDao.removeStudent(id);
		System.out.println(className + "." + methodName + "() after remove in serviec after remove");
	//	studentDao.flush();
	}

}
