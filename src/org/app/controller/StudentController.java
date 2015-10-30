package org.app.controller;

import java.util.List;

import javax.annotation.Resource;
import org.app.service.*;
import org.app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
//@RequestMapping(value = "/student", produces={ "application/xml", "application/json"},consumes={ "application/xml", "application/json"})
@SessionAttributes("/student")
@EnableWebMvc
@Configuration
@ComponentScan("org.app.service")
//@ControllerAdvice
public class StudentController {
	//@Resource
	@Autowired
	private StudentMgr studentMgr;
	
	public StudentController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET, produces={ "application/xml", "application/json"})
	@ResponseBody
	public Student findById(@PathVariable int studentId) {
		return studentMgr.getStudentbyId(studentId);
	}

	//@RequestMapping(value = "/student", method = RequestMethod.GET,headers = {"Accept=application/*+xml, application/json"}, produces={ "application/*+xml","application/json"})	
	@RequestMapping(value = "/student", method = RequestMethod.GET, produces={ MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})	
	@ResponseBody
	public List<Student> getAllStudents() {
		return studentMgr.getAllStudents();
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST, produces={ "application/xml", "application/json"},consumes={ "application/xml", "application/json"})
	@ResponseBody
	public Student addStudent(@RequestBody Student student) {
		return studentMgr.addStudent(student);
	}

	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.PUT,produces={ "application/xml", "application/json"},consumes={ "application/xml", "application/json"})

	@ResponseBody
	public Student updateStudentwithId(@RequestBody Student student, @PathVariable int studentId) {
		if (studentId != 0) {
			System.out.println("in if of updateStudentwithId 1");
			student.setId(studentId);
			return studentMgr.updateStudent(student);
		} else {
			System.out.println("in else of updateStudentwithId");
			throw new EmptyResultDataAccessException("please update with id by /student/studentid", 1);
		}
	}

	@RequestMapping(value = "/student", method = RequestMethod.PUT,produces={ "application/xml", "application/json"},consumes={ "application/xml", "application/json"})
	@ResponseBody
	public Student updateStudent(@RequestBody Student student) {
		if (student.getId() == 0l) {
			System.out.println("in if of updateStudent");
			throw new EmptyResultDataAccessException("please update with id", 1);

		} else {
			System.out.println("in else of updateStudent 1");
			return studentMgr.updateStudent(student);

		}
	}

	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable int studentId) {
		if (studentId != 0l) {
			System.out.println("in if of delete");
			studentMgr.removeStudent(studentId);
		} else{
			System.out.println("in else of delete");
			throw new EmptyResultDataAccessException(
					"please delete student with id by /student/studentid otherwise whole database corrupt", 1);
		}
	}

	@RequestMapping(value = "/student/status/{studentId}", method = RequestMethod.GET,produces={ "application/xml", "application/json"})
	@ResponseBody
	public StudentStatus findStatusById(@PathVariable int studentId) {
		return studentMgr.getStudentStatusbyId(studentId);
	}

}
