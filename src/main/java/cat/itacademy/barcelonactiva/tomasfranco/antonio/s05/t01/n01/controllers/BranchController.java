package cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.tomasfranco.antonio.s05.t01.n01.model.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/sucursal")
public class BranchController {

    @Autowired
    OfficeService branchService;

    @GetMapping(value = {"/home", "/"})
    public String showHome() {
        return "home";
    }

    @GetMapping("/getAll")
    public String getAllBranches(Model model) {
        try {
            model.addAttribute("branches", branchService.getAllBranches());
            return "branches";
        } catch (Exception e) {
            return "Not found";
        }
    }

    @GetMapping("/getOne/{id}")
    public String getBranchById(@PathVariable("id") Integer id, Model model) {
        try {
            BranchDTO branchDTO = branchService.getBranchById(id).get();
            model.addAttribute("branch", branchDTO);
            return "branch";
        } catch (Exception e) {
            return "Not found";
        }
    }

    @PostMapping("/save")
    public String addBranch(@ModelAttribute BranchDTO branch, Model model) {
        branchService.addBranch(branch);
        model.addAttribute("branches", branchService.getAllBranches());
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        BranchDTO branchDTO = new BranchDTO();
        model.addAttribute("branch", branchDTO);
        return "add";
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        BranchDTO branchDTO = new BranchDTO();
        model.addAttribute("branch", branchDTO);
        return "update";
    }

    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        model.addAttribute("branches", branchService.getAllBranches());
        return "delete";
    }

    @PostMapping("/updateBranch")
    public String updateBranch(@ModelAttribute BranchDTO branch) {
        Optional<BranchDTO> branchToUpdate = branchService.getBranchByName(branch.getBranchName());

        if (branchToUpdate.isPresent()) {
            BranchDTO _branch = branchToUpdate.get();
            _branch.setPk_branchId(branchToUpdate.get().getPk_branchId());
            _branch.setBranchName(branch.getBranchName());
            _branch.setBranchCountry(branch.getBranchCountry());
            branchService.updateBranch(_branch);
            return "redirect:/sucursal/getAll";
        } else {
            return "not_found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBranch(@ModelAttribute BranchDTO branch, @PathVariable("id") Integer id) {
        try {
            branchService.deleteBranch(id);
            return "redirect:/sucursal/getAll";
        } catch (Exception e) {
            return "not_found";
        }
    }

    @GetMapping("/deleteByRequestParam")
    public String deleteBranchByRequestParam(@RequestParam Integer id) {
        try {
            branchService.deleteBranch(id);
            return "redirect:/sucursal/getAll";
        } catch (Exception e) {
            return "not_found";
        }
    }
}
