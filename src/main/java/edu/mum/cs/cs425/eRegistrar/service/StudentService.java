package edu.mum.cs.cs425.eRegistrar.service;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long studentId);

    Student saveStudent(Student student);

    void deleteStudent(Long studentId);


}
