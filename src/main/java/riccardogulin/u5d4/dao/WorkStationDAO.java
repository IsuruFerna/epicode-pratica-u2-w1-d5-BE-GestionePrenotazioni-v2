package riccardogulin.u5d4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardogulin.u5d4.entities.WorkStation;

@Repository
public interface WorkStationDAO extends JpaRepository<WorkStation, Long> {
}
