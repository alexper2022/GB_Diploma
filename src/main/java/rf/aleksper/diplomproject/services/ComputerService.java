package rf.aleksper.diplomproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rf.aleksper.diplomproject.entities.ComputerEntity;
import rf.aleksper.diplomproject.repositories.ComputerRepository;

import java.util.List;

@Service("computerService")
@RequiredArgsConstructor
public class ComputerService {
    private final ComputerRepository computerRepository;

    public List<ComputerEntity> findAll() {
        return computerRepository.findAll();
    }

    public void addComputer(ComputerEntity computerEntity) {
        computerRepository.save(computerEntity);
    }

    public ComputerEntity findById(Long id) {
        return computerRepository.findById(id).orElse(null);
    }

    public void deleteComputer(Long id) {
        computerRepository.deleteById(id);
    }
}
