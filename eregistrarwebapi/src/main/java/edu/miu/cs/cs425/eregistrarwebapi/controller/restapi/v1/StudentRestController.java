package edu.miu.cs.cs425.eregistrarwebapi.controller.restapi.v1;

import edu.miu.cs.cs425.eregistrarwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = { "/eregistrar/api/student" })
public class StudentRestController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = { "list" })
    public ResponseEntity<List<Student>> listStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping(value = { "/get/{studentId}" })
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping(value = { "/register" })
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.addNewStudent(student), HttpStatus.CREATED);
    }

    @PutMapping(value = { "/update/{studentId}" })
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student, @PathVariable Long studentId)
            throws StudentNotFoundException {
        Student updateStudent = studentService.getStudentById(studentId);
        if (updateStudent == null)
            return new ResponseEntity<>("Student ID is invalid", HttpStatus.NOT_FOUND);
        studentService.updatetStudent(student, studentId);
        return new ResponseEntity<>("Student has been updated", HttpStatus.OK);
    }

    @DeleteMapping(value = { "/delete/{studentId}" })
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) throws StudentNotFoundException {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student deleted ID: " + studentId, HttpStatus.OK);
    }
}
