package rf.aleksper.diplomproject.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rf.aleksper.diplomproject.entities.PrinterEntity;
import rf.aleksper.diplomproject.services.PrinterService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "printer")
public class PrinterController {
    private final PrinterService printerService;

    @GetMapping(value = "all")
    public String all(Model model) {
        model.addAttribute("printers", printerService.findAll());
        return "printer/all";
    }

    @GetMapping(value = {"/add"})
    public String showAddPrinterPage(Model model) {
        PrinterEntity newPrinter = new PrinterEntity();
        model.addAttribute("newPrinter", newPrinter);
        return "printer/add";
    }

    @PostMapping(value = {"/add"})
    public String savePrinter(Model model, @ModelAttribute("newPrinter") PrinterEntity newPrinter) {
        printerService.addPrinter(newPrinter);
        return "redirect:/printer/all";
    }

    @GetMapping(value = {"delete/{id}"})
    public String showDeletePrinterPage(Model model, @ModelAttribute("id") Long id) {
        PrinterEntity printerDel = printerService.findById(id);
        model.addAttribute("printerDel", printerDel);
        return "printer/delete";
    }

    @PostMapping(value = {"delete/{id}"})
    public String deletePrinterPage(Model model, @ModelAttribute("id") Long id) {
        log.info("Delete printer (printerName) : " + printerService.findById(id).getPrinterName());
        printerService.deletePrinter(id);
        return "redirect:/printer/all";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String showEditPrinter(Model model, @ModelAttribute("id") Long id) {
        log.info("Start edit printer (printerName) : " + printerService.findById(id).getPrinterName());
        PrinterEntity editPrinter = printerService.findById(id);
        model.addAttribute("editPrinter", editPrinter);
        return "printer/edit";
    }

    @PostMapping(value = {"/edit/{id}"})
    public String saveEditPrinter(Model model, @ModelAttribute("id") Long id, @ModelAttribute("editPrinter") PrinterEntity editPrinter) {
        log.info("Save edited printer: printerName={}", printerService.findById(id).getPrinterName());
        PrinterEntity printerEntity = printerService.findById(id);
        printerEntity.setPrinterName(editPrinter.getPrinterName());
        printerEntity.setPrinterBrand(editPrinter.getPrinterBrand());
        printerEntity.setPrinterModel(editPrinter.getPrinterModel());
        printerEntity.setPrinterSerialNumber(editPrinter.getPrinterSerialNumber());
        printerEntity.setPrinterIsMFU(editPrinter.isPrinterIsMFU());
        printerEntity.setPrinterIpAddress(editPrinter.getPrinterIpAddress());
        printerService.addPrinter(printerEntity);
        return "redirect:/printer/all";
    }
}
