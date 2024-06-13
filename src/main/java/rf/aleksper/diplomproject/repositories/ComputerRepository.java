package rf.aleksper.diplomproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rf.aleksper.diplomproject.entities.ComputerEntity;

public interface ComputerRepository extends JpaRepository<ComputerEntity, Long> {

}
