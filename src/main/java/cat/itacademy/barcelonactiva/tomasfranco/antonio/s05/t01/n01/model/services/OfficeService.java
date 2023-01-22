package cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.dto.BranchDTO;

import java.util.List;
import java.util.Optional;

public interface OfficeService {
    List<BranchDTO> getAllBranches();

    Optional<BranchDTO> getBranchById(Integer id);


    BranchDTO addBranch(BranchDTO branch);


    Optional<BranchDTO> getBranchByName(String branchName);

    BranchDTO updateBranch(BranchDTO branch);


    void deleteBranch(Integer id);
}
