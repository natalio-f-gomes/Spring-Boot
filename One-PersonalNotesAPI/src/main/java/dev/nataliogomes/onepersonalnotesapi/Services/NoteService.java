package dev.nataliogomes.onepersonalnotesapi.Services;

import dev.nataliogomes.onepersonalnotesapi.Models.NoteModel;
import dev.nataliogomes.onepersonalnotesapi.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    public NoteModel addNote(NoteModel note){
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        return repository.save(note);
    }

    public Optional<NoteModel> getNoteById(Long id){
        return repository.findById(id);
    }

    public List<NoteModel> getAllNotes(){
        return repository.findAll();
    }

    public NoteModel updateNote(Long id, NoteModel updatedNote){
        NoteModel note = getNoteById(id).orElseThrow(() -> new RuntimeException("product with id " + id + " not found"));
        note.setUpdatedAt(LocalDateTime.now());
        note.setTitle(updatedNote.getTitle());
        note.setDescription(updatedNote.getDescription());
        return repository.save(note);
    }

    public ResponseEntity.BodyBuilder deleteNoteById(Long id){
        NoteModel note = getNoteById(id).orElseThrow(() -> new RuntimeException("product with id " + id + " not found"));
        repository.delete(note);
        return ResponseEntity.status(HttpStatus.OK);
    }

}
