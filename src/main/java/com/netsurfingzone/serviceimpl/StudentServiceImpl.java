package com.netsurfingzone.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Student save(Student student) {
		entityManager.persist(student);
		return student;
	}

	@Transactional
	public List<Student> getStudents() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);
		criteriaQuery.orderBy(criteriaBuilder.desc(studentRoot.get("name")));
		List<Student> students = entityManager.createQuery(criteriaQuery).getResultList();
		return students;
	}

}
