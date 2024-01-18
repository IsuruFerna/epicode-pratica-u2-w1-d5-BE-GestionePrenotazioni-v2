package riccardogulin.u5d4.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riccardogulin.u5d4.entities.WorkStation;
import riccardogulin.u5d4.entities.WorkStationType;
import riccardogulin.u5d4.exceptions.ItemNotFoundException;

import java.time.LocalDate;


@Service
@Slf4j
public class WorkStationService {
    @Autowired
    WorkStationDAO workStationDAO;

    public void save(WorkStation workStation) {
        workStationDAO.save(workStation);
        log.info("Work stations saved!");
    }

    public WorkStation findById(long id) throws ItemNotFoundException {
        return workStationDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public WorkStation findByIdAndUpdateDate(long id, LocalDate localDate) {
        WorkStation workStation = this.findById(id);
        workStation.setOccupiedDate(localDate);
        return workStationDAO.save(workStation);
    }

    public void availableWorkstations() {
        System.out.println("************ All available workstations *************");
        workStationDAO.filterByNotOccupied().forEach(System.out::println);
    }

    public void notAvailableWorkStationsByDate(LocalDate localDate) {
        System.out.println("******************* these are not availeble in " + localDate + " ********************");
        workStationDAO.filterByDateWorkStaionOccupied(localDate).forEach(System.out::println);
    }

//    public void availableWorkStationsByDate(LocalDate localDate) {
//        System.out.println("******************* These are available in " + localDate + " ***************************");
//        workStationDAO.filterByDateAvailableWorkStation(localDate).forEach(System.out::println);
//    }
}
