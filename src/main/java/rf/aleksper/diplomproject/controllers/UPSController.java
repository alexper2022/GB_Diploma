package rf.aleksper.diplomproject.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rf.aleksper.diplomproject.entities.UPSEntity;
import rf.aleksper.diplomproject.services.UPSService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "ups")
public class UPSController {
    private final UPSService upsService;

    @GetMapping(value = "all")
    public String all(Model model) {
        model.addAttribute("ups", upsService.findAll());
        return "ups/all";
    }

    @GetMapping(value = {"/add"})
    public String showAddUpsPage(Model model) {
        UPSEntity newUps = new UPSEntity();
        model.addAttribute("newUps", newUps);
        return "ups/add";
    }

    @PostMapping(value = {"/add"})
    public String saveUps(Model model, @ModelAttribute("newUps") UPSEntity newUps) {
        upsService.addUps(newUps);
        return "redirect:/ups/all";
    }

    @GetMapping(value = {"delete/{id}"})
    public String showDeleteUpsPage(Model model, @ModelAttribute("id") Long id) {
        UPSEntity upsDel = upsService.findById(id);
        model.addAttribute("upsDel", upsDel);
        return "ups/delete";
    }

    @PostMapping(value = {"delete/{id}"})
    public String deleteUpsPage(Model model, @ModelAttribute("id") Long id) {
        log.info("Delete ups (upsName) : " + upsService.findById(id).getUpsName());
        upsService.deleteUps(id);
        return "redirect:/ups/all";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String showEditUps(Model model, @ModelAttribute("id") Long id) {
        log.info("Start edit ups (upsName) : " + upsService.findById(id).getUpsName());
        UPSEntity editUps = upsService.findById(id);
        model.addAttribute("editUps", editUps);
        return "ups/edit";
    }

    @PostMapping(value = {"/edit/{id}"})
    public String saveEditUps(Model model, @ModelAttribute("id") Long id, @ModelAttribute("editUps") UPSEntity editUps) {
        log.info("Save edited ups: upsName={}", upsService.findById(id).getUpsName());
        UPSEntity upsEntity = upsService.findById(id);
        upsEntity.setUpsName(editUps.getUpsName());
        upsEntity.setUpsManufacturer(editUps.getUpsManufacturer());
        upsEntity.setUpsModel(editUps.getUpsModel());
        upsEntity.setUpsSerialNumber(editUps.getUpsSerialNumber());
        upsService.addUps(upsEntity);
        return "redirect:/ups/all";
    }
}