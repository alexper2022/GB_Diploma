package rf.aleksper.diplomproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rf.aleksper.diplomproject.entities.PrinterEntity;

public interface PrinterRepository extends JpaRepository<PrinterEntity, Long> {
}
