package dev.nataliogomes.twosimpleschoolmanagementsystem.Repositories;

import dev.nataliogomes.twosimpleschoolmanagementsystem.Models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
