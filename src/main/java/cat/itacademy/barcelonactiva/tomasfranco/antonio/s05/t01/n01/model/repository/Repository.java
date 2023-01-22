package cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Repository extends JpaRepository<Branch, Integer> {
    Optional<Branch> findFirstByBranchName(String branchName);
}
