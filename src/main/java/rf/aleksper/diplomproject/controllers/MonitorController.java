package rf.aleksper.diplomproject.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rf.aleksper.diplomproject.entities.MonitorEntity;
import rf.aleksper.diplomproject.services.MonitorService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "monitor")
public class MonitorController {
    private final MonitorService monitorService;

    @GetMapping(value = "all")
    public String all(Model model) {
        model.addAttribute("monitors", monitorService.findAll());
        return "monitor/all";
    }

    @GetMapping(value = {"/add"})
    public String showAddMonitorPage(Model model) {
        MonitorEntity newMonitor = new MonitorEntity();
        model.addAttribute("newMonitor", newMonitor);
        return "monitor/add";
    }

    @PostMapping(value = {"/add"})
    public String saveMonitor(Model model, @ModelAttribute("newMonitor") MonitorEntity newMonitor) {
        monitorService.addMonitor(newMonitor);
        return "redirect:/monitor/all";
    }

    @GetMapping(value = {"delete/{id}"})
    public String showDeleteMonitorPage(Model model, @ModelAttribute("id") Long id) {
        MonitorEntity monitorDel = monitorService.findById(id);
        model.addAttribute("monitorDel", monitorDel);
        return "monitor/delete";
    }

    @PostMapping(value = {"delete/{id}"})
    public String deleteMonitorPage(Model model, @ModelAttribute("id") Long id) {
        log.info("Delete monitor (monitorName) : " + monitorService.findById(id).getMonitorName());
        monitorService.deleteMonitor(id);
        return "redirect:/monitor/all";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String showEditMonitor(Model model, @ModelAttribute("id") Long id) {
        log.info("Start edit monitor (monitorName) : " + monitorService.findById(id).getMonitorName());
        MonitorEntity editMonitor = monitorService.findById(id);
        model.addAttribute("editMonitor", editMonitor);
        return "monitor/edit";
    }

    @PostMapping(value = {"/edit/{id}"})
    public String saveEditMonitor(Model model, @ModelAttribute("id") Long id, @ModelAttribute("editMonitor") MonitorEntity editMonitor) {
        log.info("Save edited monitor: monitorName={}", monitorService.findById(id).getMonitorName());
        MonitorEntity monitorEntity = monitorService.findById(id);
        monitorEntity.setMonitorName(editMonitor.getMonitorName());
        monitorEntity.setMonitorManufacturer(editMonitor.getMonitorManufacturer());
        monitorEntity.setMonitorModel(editMonitor.getMonitorModel());
        monitorEntity.setMonitorSerialNumber(editMonitor.getMonitorSerialNumber());
        monitorEntity.setMonitorDiagonal(editMonitor.getMonitorDiagonal());
        monitorEntity.setMonitorResolutionX(editMonitor.getMonitorResolutionX());
        monitorEntity.setMonitorResolutionY(editMonitor.getMonitorResolutionY());
        monitorEntity.setMonitorDescription(editMonitor.getMonitorDescription());
        monitorService.addMonitor(monitorEntity);
        return "redirect:/monitor/all";
    }

}
