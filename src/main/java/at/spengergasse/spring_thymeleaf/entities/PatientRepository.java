package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Optional<Patient> findBySVnummer(String firstName, String lastName);
    boolean existsBySVnummer(String firstName, String lastName);
}
