package cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService implements OfficeService {

    @Autowired
    Repository repository;

    public List<BranchDTO> getAllBranches() {
        return repository.findAll()
                .stream()
                .map(this::convertBranchEntityToDto)
                .collect(Collectors.toList());
    }

    public Optional<BranchDTO> getBranchById(Integer id) {
        return repository.findById(id).map(this::convertBranchEntityToDto);
    }

    public BranchDTO addBranch(BranchDTO branch) {
        Branch addedBranch = repository.save(new Branch(branch.getBranchName(), branch.getBranchCountry()));
        return new BranchDTO(addedBranch.getId(), addedBranch.getBranchName(), addedBranch.getCountry());
    }

    public Optional<BranchDTO> getBranchByName(String branchName) {
        Optional<Branch> branchToFind = repository.findFirstByBranchName(branchName);
        return branchToFind.map(this::convertBranchEntityToDto);
    }

    public BranchDTO updateBranch(BranchDTO branchToUpdate) {
        Branch updatedBranch = repository.save(new Branch(branchToUpdate.getPk_branchId(), branchToUpdate.getBranchName(), branchToUpdate.getBranchCountry()));
        return convertBranchEntityToDto(updatedBranch);
    }

    public void deleteBranch(Integer id) {
        repository.deleteById(id);
    }

    private BranchDTO convertBranchEntityToDto (Branch branch){
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setPk_branchId(branch.getId());
        branchDTO.setBranchName(branch.getBranchName());
        branchDTO.setBranchCountry(branch.getCountry());

        return branchDTO;
    }
}
