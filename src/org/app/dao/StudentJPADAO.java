package org.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.app.model.Student;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class StudentJPADAO implements StudentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	String className = this.getClass().getSimpleName();

	@Override
	public Student findByIdOrThrowException(int id) {
		Student student = entityManager.find(Student.class, id);
		if (student == null) {
			throw new EmptyResultDataAccessException("student with id=" + id + " wasn't found.", 1);
		}
		return student;
	}

	public StudentJPADAO() {
		// TODO Auto-generated constructor stub
		System.out.println("StudentJPADAO********Constructor()");
	
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() before EMF");
		student.setCreated(new Date());
 System.out.println("Classname.Methodname" + className + "." + methodName + "() after EMF");
		entityManager.persist(student);
		// pm.persist(student);
		System.out.println("Classname.Methodname" + className + "." + methodName + "() after persist");
	
		return student;
		// }
	}

	@Override
	public void removeStudent(int id) {
		Student student = new Student();
		student.setId(id);
		
		Student studentfound = entityManager.find(Student.class, id);
		
		if (studentfound == null) {
			System.out.println("if null of jpa");
			throw new EmptyResultDataAccessException("student with id "+student.getId()+" wasn't found.", 1);
		}else{
			System.out.println("else of jpa");
		
		entityManager.remove(studentfound);
		
		}
	
	}

	@Override
	public Student updateStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");
String name = student.getName();
	
		Student studentfound = entityManager.find(Student.class, student.getId());
			
			if (studentfound == null) {
				System.out.println("if null of jpa");
				throw new EmptyResultDataAccessException("student with id "+student.getId()+" wasn't found.", 1);
			}else{
				System.out.println("else of jpa");
			student.setName(name);
			student.setCreated(new Date());
			entityManager.merge(student);
			return student;
			}
	
			
	}

	// @SuppressWarnings("finally")
	@Override
	public List<Student> listStudents() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		String query = "";
		List<Student> ls = null;
		
		query = "select T from " + Student.class.getName() + " T";

		Query q = entityManager.createQuery(query);
		System.out.println(className + "." + methodName + "() after createquery");

		ls = q.getResultList();
		// sop is for lazy reading
		System.out.println(className + "." + methodName + "() list size is " + ls.size());
		if (ls.size() == 0) {System.out.println("in if ls.size0");
			throw new EmptyResultDataAccessException("Please Add students there are no students in list", 1);
		}else{
			System.out.println("in else ls.size");
		return ls;
		}
	}

}
