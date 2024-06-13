package rf.aleksper.diplomproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rf.aleksper.diplomproject.entities.MonitorEntity;
import rf.aleksper.diplomproject.repositories.MonitorRepository;

import java.util.List;

@Service("monitorService")
@RequiredArgsConstructor
public class MonitorService {
    private final MonitorRepository monitorRepository;

    public List<MonitorEntity> findAll() {
        return monitorRepository.findAll();
    }

    public MonitorEntity addMonitor(MonitorEntity monitorEntity) {
        return monitorRepository.save(monitorEntity);
    }


    public MonitorEntity findById(Long id) {
        return monitorRepository.findById(id).orElse(null);
    }

    public void deleteMonitor(Long id) {
        monitorRepository.deleteById(id);
    }
}
