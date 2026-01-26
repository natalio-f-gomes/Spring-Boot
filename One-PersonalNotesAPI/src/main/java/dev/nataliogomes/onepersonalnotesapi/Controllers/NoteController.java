package dev.nataliogomes.onepersonalnotesapi.Controllers;

import dev.nataliogomes.onepersonalnotesapi.Models.NoteModel;
import dev.nataliogomes.onepersonalnotesapi.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("add/note")
    public ResponseEntity<NoteModel> addNote(@RequestBody NoteModel newNote){
        NoteModel result = noteService.addNote(newNote);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("update/note/{id}")
    public ResponseEntity<NoteModel> updateNote(@RequestBody NoteModel newNote, @PathVariable Long id){
        NoteModel updated = noteService.updateNote(id, newNote);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @GetMapping("get/note/{id}")
    public Optional<NoteModel> getNoteById(@PathVariable Long id){
        return  noteService.getNoteById(id);
    }

    @DeleteMapping("delete/note/{id}")
    public ResponseEntity.BodyBuilder deleteNoteById(@PathVariable Long id){
        return  noteService.deleteNoteById(id);
    }

    @GetMapping("get/note/all")
    public List<NoteModel> getNotes(){
        return  noteService.getAllNotes();
    }



}
