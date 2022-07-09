package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = { "/eregistrar/student" })
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = { "/list" })
    public ModelAndView listStudents() {
        var students = studentService.getAllStudents();

        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }

    @GetMapping(value = { "/new" })
    public String displayNewStudentForm(Model model) {
        var newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "secured/student/new";
    }

    @PostMapping(value = { "/new" })
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
            Model model) {
        System.out.println(student);
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }
        studentService.addNewStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = { "edit/{studentId}" })
    public String displayEditStudentForm(@PathVariable Long studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "secured/student/edit";
        }
        return "redirect:/eregistrar/student/list";
    }

    @PostMapping(value = { "/update" })
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("erros", bindingResult.getAllErrors());
            return "secured/student/edit";
        }
        studentService.updatetStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = "/delete/{studentId}")
    public String delePublisher(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";
    }
}
