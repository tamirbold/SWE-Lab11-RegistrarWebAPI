package edu.miu.cs.cs425.eregistrarwebapi.service.impl;

import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrarwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addNewStudent(Student student) {
        var newStudent = studentRepository.save(student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        var students = studentRepository.findAllByOrderByFirstNameAsc();
        return students;
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId).orElseThrow(
                () -> new StudentNotFoundException(String.format("Student with ID: %d is not found", studentId)));
    }

    @Override
    public Student updatetStudent(Student student, Long studentId) {
        Student updateStudent = studentRepository.findById(studentId).get();
        updateStudent.setStudentNumber(student.getStudentNumber());
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setMiddleName(student.getMiddleName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setCgpa(student.getCgpa());
        updateStudent.setEnrollmentDate(student.getEnrollmentDate());
        updateStudent.setIsInternational(student.isIsInternational());
        return studentRepository.save(updateStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);

    }

    @Override
    public List<Student> getByKeyword(String keyword) {
        return studentRepository.findByKeyword(keyword);
    }
}
