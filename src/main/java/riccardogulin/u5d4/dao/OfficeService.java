package riccardogulin.u5d4.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riccardogulin.u5d4.entities.Office;
import riccardogulin.u5d4.exceptions.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OfficeService {
    @Autowired
    OfficeDAO officeDAO;

    public void save(Office office) {
        officeDAO.save(office);
        log.info("Office saved successfully!");
    }

    public Office findById(Long id) throws ItemNotFoundException{
        return officeDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public List<Office> findByCity(String city) {
        List<Office> offices = officeDAO.findByCity(city);
        offices.forEach(office -> office.getWorkStations().size());
        return offices;
    }
}
