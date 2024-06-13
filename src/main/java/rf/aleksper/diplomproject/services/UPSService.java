package rf.aleksper.diplomproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rf.aleksper.diplomproject.entities.UPSEntity;
import rf.aleksper.diplomproject.repositories.UPSRepository;

import java.util.List;

@Service("upsService")
@RequiredArgsConstructor
public class UPSService {
    private final UPSRepository upsEntityRepository;

    public List<UPSEntity> findAll() {
        return upsEntityRepository.findAll();
    }

    public UPSEntity addUps(UPSEntity newUps) {
        return upsEntityRepository.save(newUps);
    }

    public UPSEntity findById(Long id) {
        return upsEntityRepository.findById(id).orElse(null);
    }

    public void deleteUps(Long id) {
        upsEntityRepository.deleteById(id);
    }
}
