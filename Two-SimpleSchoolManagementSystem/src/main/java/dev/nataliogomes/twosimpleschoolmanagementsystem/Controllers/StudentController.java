package dev.nataliogomes.twosimpleschoolmanagementsystem.Controllers;

import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.StudentModel;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Repositories.StudentRepository;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Services.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel newStudent){
        StudentModel created =  studentService.createStudent(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("get/all")
    public List<StudentModel> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("get/{id}")
    public StudentModel getStudentById(@PathVariable Long id){
        return studentService.getStudentByID(id);
    }

    @PutMapping("update/{id}")
    public StudentModel updateStudent( @RequestBody StudentModel student,@PathVariable Long id){
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<StudentModel> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/get/{studentID}/register/{subjectID}")
    public ResponseEntity<StudentModel> registerForClass(@PathVariable Long studentID, @PathVariable Long subjectID){
        StudentModel result = studentService.registerForClass(studentID,subjectID);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

