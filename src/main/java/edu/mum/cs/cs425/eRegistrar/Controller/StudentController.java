package edu.mum.cs.cs425.eRegistrar.Controller;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list"; // The view name for listing students
    }

    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/create"; // The view name for the student creation form
    }

    @PostMapping("/save")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/list"; // Redirect to the student list page after saving
    }

    @GetMapping("/edit")
    public String editStudentForm(@RequestParam("id") Long studentId, Model model) {
        model.addAttribute("student", studentService.getStudentById(studentId).orElse(null));
        return "student/edit"; // The view name for the student edit form
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students/list"; // Redirect to the student list page after deletion
    }
}

