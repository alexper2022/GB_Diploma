package rf.aleksper.diplomproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rf.aleksper.diplomproject.entities.PrinterEntity;
import rf.aleksper.diplomproject.repositories.PrinterRepository;

import java.util.List;

@Service("printerService")
@RequiredArgsConstructor
public class PrinterService {
    private final PrinterRepository printerRepository;

    public List<PrinterEntity> findAll() {
        return printerRepository.findAll();
    }

    public PrinterEntity addPrinter(PrinterEntity printer) {
        return printerRepository.save(printer);
    }

    public PrinterEntity findById(Long id) {
        return printerRepository.findById(id).orElse(null);
    }

    public void deletePrinter(Long id) {
        printerRepository.deleteById(id);
    }
}
