package edu.miu.cs.cs425.eregistrarwebapi.service;

import edu.miu.cs.cs425.eregistrarwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
    public abstract Student addNewStudent(Student student);

    public abstract List<Student> getAllStudents();

    public abstract Student getStudentById(Long studentId) throws StudentNotFoundException;

    Student updatetStudent(Student updateStudent, Long studentId);

    void deleteStudentById(Long studentId);

    public abstract List<Student> getByKeyword(String keyword);
}
