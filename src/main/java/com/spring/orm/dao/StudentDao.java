// Jai Swamianarayan KESHAV , Swami-Shreeji
package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Student student) {
		Integer i = (Integer)hibernateTemplate.save(student);
		return i;
	}
	
	// we only need @Transactional annotation for create, update and delete operations.We do not need it for get/read operations
	public Student getStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	public List<Student> getAllStudents(){
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class,studentId);
		hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}
}
