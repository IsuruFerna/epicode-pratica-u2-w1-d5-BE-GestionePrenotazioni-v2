package riccardogulin.u5d4.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riccardogulin.u5d4.entities.WorkStation;
import riccardogulin.u5d4.entities.WorkStationType;


@Service
@Slf4j
public class WorkStationService {
    @Autowired
    WorkStationDAO workStationDAO;

    public void save(WorkStation workStation) {
        workStationDAO.save(workStation);
        log.info("Work stations saved!");
    }
}
