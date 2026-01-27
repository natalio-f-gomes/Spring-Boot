package dev.nataliogomes.twosimpleschoolmanagementsystem.Services;

import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.StudentModel;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.SubjectModel;
import dev.nataliogomes.twosimpleschoolmanagementsystem.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectModel addSubject(SubjectModel newSubject){
        newSubject.setCreatedAt(LocalDateTime.now());
        newSubject.setUpdatedAt(LocalDateTime.now());
        return subjectRepository.save(newSubject);
    }

    public SubjectModel getSubjectById(Long id){
        return subjectRepository.findById(id).orElseThrow(()-> new RuntimeException("Subject with id "+ id + " not found"));
    }

    public List<SubjectModel> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public void deleteSubjectById(Long id){
        SubjectModel subject = getSubjectById(id);
        subjectRepository.delete(subject);
    }

    public SubjectModel updateSubjectById(SubjectModel updatedSubject, Long id){
        SubjectModel subject = getSubjectById(id);
        subject.setUpdatedAt(LocalDateTime.now());
        subject.setTitle(updatedSubject.getTitle());
        subject.setCRN(updatedSubject.getCRN());
        return subjectRepository.save(subject);
    }
}
