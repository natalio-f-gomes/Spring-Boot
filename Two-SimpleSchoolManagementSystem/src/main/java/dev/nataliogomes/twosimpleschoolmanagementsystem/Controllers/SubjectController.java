package dev.nataliogomes.twosimpleschoolmanagementsystem.Controllers;

import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.StudentModel;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.SubjectModel;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/add")
    public ResponseEntity<SubjectModel> createSubject(@RequestBody SubjectModel newSubject){
        SubjectModel created = subjectService.addSubject(newSubject);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SubjectModel> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubjectById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubjectModel> updateSubject(@RequestBody SubjectModel subject,@PathVariable Long id){
        SubjectModel updatedSubject = subjectService.updateSubjectById(subject, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSubject);
    }

    @GetMapping("/get/{id}")
    public SubjectModel getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @GetMapping("/get/all")
    public List<SubjectModel> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
}
