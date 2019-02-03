package org.sanal.srp.service;

import java.util.List;

import org.sanal.srp.entities.Student;

/**
 * @author Nalluru Sunil Reddy
 *
 */
public interface StudentService {

	public void saveStudent(Student student);

	public List<Student> searchStudents(Student student);

	public List<Student> searchStudentsQueryDsl(Student student);

	public Student findById(Integer studentId);
}
