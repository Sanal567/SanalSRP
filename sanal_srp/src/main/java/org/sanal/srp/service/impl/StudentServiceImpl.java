/**
 * 
 */
package org.sanal.srp.service.impl;

import java.util.List;
import java.util.Optional;

import org.sanal.srp.entities.QStudent;
import org.sanal.srp.entities.Student;
import org.sanal.srp.repository.BaseRepository;
import org.sanal.srp.repository.StudentRepository;
import org.sanal.srp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author Nalluru Sunil Reddy
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository<Student, Integer> studentRepository;

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> searchStudents(Student student) {

		String firstName = student.getFirstName();
		String lastName = student.getLastName();

		if ((firstName != null && firstName.trim().length() != 0)
				&& (lastName != null && lastName.trim().length() != 0))
			return studentRepository
					.findDistinctStudentByFirstNameContainingOrLastNameContainingAllIgnoreCaseOrderByFirstNameAsc(
							firstName, lastName);
		else if (firstName != null && firstName.trim().length() != 0)
			return studentRepository.findByFirstNameIgnoreCaseContainingOrderByFirstNameAsc(firstName);
		else
			return studentRepository.findByLastNameIgnoreCaseContainingOrderByLastNameAsc(lastName);

	}

	@Override
	public Student findById(Integer studentId) {
		Optional<Student> optional = studentRepository.findById(studentId);
		Student s = null;
		if (optional.isPresent())
			s = optional.get();
		return s;
	}

	@Autowired 
	private BaseRepository baseRepository;
	
	@Override
	public List<Student> searchStudentsQueryDsl(Student student) {
		BooleanExpression booleanExpression = QStudent.student.firstName.containsIgnoreCase(student.getFirstName())
				.and(QStudent.student.lastName.containsIgnoreCase(student.getLastName()));
	//	baseRepository.findAll(booleanExpression);
		return  (List<Student>) studentRepository.findAll(booleanExpression);
	}

}
