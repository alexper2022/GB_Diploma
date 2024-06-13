package rf.aleksper.diplomproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rf.aleksper.diplomproject.entities.MonitorEntity;

public interface MonitorRepository extends JpaRepository<MonitorEntity, Long> {
}
