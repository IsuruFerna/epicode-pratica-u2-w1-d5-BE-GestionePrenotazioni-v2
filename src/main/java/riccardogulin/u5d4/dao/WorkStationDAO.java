package riccardogulin.u5d4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import riccardogulin.u5d4.entities.User;
import riccardogulin.u5d4.entities.WorkStation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkStationDAO extends JpaRepository<WorkStation, Long> {
    @Query("SELECT w FROM WorkStation w WHERE w.occupiedDate IS NULL")
    List<WorkStation> filterByNotOccupied();

    @Query("SELECT w FROM WorkStation w WHERE w.occupiedDate = :date")
    List<WorkStation> filterByDateWorkStaionOccupied(@Param("date")LocalDate localDate);

    @Query("SELECT w FROM WorkStation w JOIN w.users u WHERE u.id = :userId AND w.occupiedDate != :date")
    List<WorkStation> filterAvailabilityByDate(@Param("userId") long userId, @Param("date")LocalDate localDate);


//    @Query("SELECT w FROM WorkStation w WHERE w.occupiedDate != :date")
//    List<WorkStation> filterByDateAvailableWorkStation(@Param("date")LocalDate localDate);

}
