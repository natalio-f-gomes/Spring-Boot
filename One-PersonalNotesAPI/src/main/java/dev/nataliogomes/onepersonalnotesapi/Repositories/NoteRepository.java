package dev.nataliogomes.onepersonalnotesapi.Repositories;

import dev.nataliogomes.onepersonalnotesapi.Models.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteModel, Long> {
}
