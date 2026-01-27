package dev.nataliogomes.twosimpleschoolmanagementsystem.Repositories;

import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, Long> {
}
