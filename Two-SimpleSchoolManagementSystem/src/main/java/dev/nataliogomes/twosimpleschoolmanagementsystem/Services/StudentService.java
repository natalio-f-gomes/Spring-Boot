package dev.nataliogomes.twosimpleschoolmanagementsystem.Services;

import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.StudentModel;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.SubjectModel;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Repositories.StudentRepository;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;


    public StudentModel createStudent(StudentModel newStudent){
        newStudent.setCreatedAt(LocalDateTime.now());
        newStudent.setUpdatedAt(LocalDateTime.now());
        return studentRepository.save(newStudent);
    }

    public StudentModel getStudentByID(Long id){
        return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student with id " + id + " not found"));
    }

    public StudentModel updateStudent(StudentModel newStudent, Long id){
        StudentModel student = getStudentByID(id);
        student.setUpdatedAt(LocalDateTime.now());
        student.setUsername(newStudent.getUsername());
        student.setSubjects(newStudent.getSubjects());
        return studentRepository.save(student);
    }

    public List<StudentModel> getAllStudents(){
        return studentRepository.findAll();
    }

    public void deleteStudentById(Long id){
        StudentModel student = getStudentByID(id);

        List<SubjectModel> allSubjects = subjectRepository.findAll();
        for(SubjectModel subject: allSubjects){
            if(subject.getStudentEnrolled() != null){
                subject.getStudentEnrolled().remove(student.getUsername());
                subjectRepository.save(subject);
            }
        }
        studentRepository.deleteById(id);
    }

    public StudentModel registerForClass( Long studentId,Long subjectId){
        SubjectModel subject =  subjectRepository.findById(subjectId).orElseThrow(()-> new RuntimeException("Subject with id " + subjectId + " not found"));
        StudentModel student =  studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("Student with id " + studentId + " not found"));
        //handle null pointer exception - very important
        if(subject.getStudentEnrolled() == null){subject.setStudentEnrolled(new ArrayList<>());}
        if(student.getSubjects() == null){student.setSubjects(new ArrayList<>());}

        if(!student.getSubjects().contains(subject)){
            student.getSubjects().add(subject);
            subject.getStudentEnrolled().add(student.getUsername());
        }
        //since we modified subject let's update the database
        subjectRepository.save(subject);
        return studentRepository.save(student);
    }
}
