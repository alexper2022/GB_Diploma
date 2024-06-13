package rf.aleksper.diplomproject.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rf.aleksper.diplomproject.entities.ComputerEntity;
import rf.aleksper.diplomproject.services.ComputerService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "computer")
public class ComputerController {
    private final ComputerService computerService;

    @GetMapping(value = "all")
    public String all(Model model) {
        model.addAttribute("computers", computerService.findAll());
        return "computer/all";
    }

    @GetMapping(value = {"/add"})
    public String showAddComputerPage(Model model) {
        ComputerEntity newComputer = new ComputerEntity();
        model.addAttribute("newComputer", newComputer);
        return "computer/add";
    }

    @PostMapping(value = {"/add"})
    public String saveComputer(Model model, @ModelAttribute("newComputer") ComputerEntity newComputer) {
        computerService.addComputer(newComputer);
        return "redirect:/computer/all";

    }


    @GetMapping(value = {"delete/{id}"})
    public String showDeleteComputerPage(Model model, @ModelAttribute("id") Long id) {
        ComputerEntity computerDel = computerService.findById(id);
        model.addAttribute("computerDel", computerDel);
        return "computer/delete";
    }

    @PostMapping(value = {"delete/{id}"})
    public String deleteComputerPage(Model model, @ModelAttribute("id") Long id) {
        log.info("Delete computer (computerName) : " + computerService.findById(id).getComputerName());
        computerService.deleteComputer(id);
        return "redirect:/computer/all";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String showEditComputer(Model model, @ModelAttribute("id") Long id) {
        log.info("Start edit computer (computerName) : " + computerService.findById(id).getComputerName());
        ComputerEntity editComputer = computerService.findById(id);
        model.addAttribute("editComputer", editComputer);
        return "computer/edit";
    }

    @PostMapping(value = {"/edit/{id}"})
    public String saveEditComputer(Model model, @ModelAttribute("id") Long id, @ModelAttribute("editComputer") ComputerEntity editComputer) {
        log.info("Save edited computer: computerName={}", computerService.findById(id).getComputerName());
        ComputerEntity computerEntity = computerService.findById(id);
        computerEntity.setComputerName(editComputer.getComputerName());
        computerEntity.setComputerManufacturer(editComputer.getComputerManufacturer());
        computerEntity.setComputerModel(editComputer.getComputerModel());
        computerEntity.setComputerProcessor(editComputer.getComputerProcessor());
        computerEntity.setComputerProcessorFrequencyGHz(editComputer.getComputerProcessorFrequencyGHz());
        computerEntity.setComputerRam(editComputer.getComputerRam());
        computerEntity.setComputerRamSizeGB(editComputer.getComputerRamSizeGB());
        computerEntity.setComputerVideoCard(editComputer.getComputerVideoCard());
        computerEntity.setComputerStorage(editComputer.getComputerStorage());
        computerEntity.setComputerStorageType(editComputer.getComputerStorageType());
        computerEntity.setComputerStorageSizeGB(editComputer.getComputerStorageSizeGB());
        computerEntity.setComputerOSVendor(editComputer.getComputerOSVendor());
        computerEntity.setComputerOSVersion(editComputer.getComputerOSVersion());
        computerEntity.setComputerOSArchitecture(editComputer.getComputerOSArchitecture());
        computerService.addComputer(computerEntity);
        return "redirect:/computer/all";
    }

}
