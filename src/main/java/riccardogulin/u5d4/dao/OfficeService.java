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

    public List<Office> getAllOffices() {
        return officeDAO.findAll();
    }
    public void printAllOffices() {
        System.out.println("******* All offices *********");
        officeDAO.findAll().forEach(System.out::println);
    }

    public void printOfficesByCity(String city) {
        System.out.println("******** Offices available in " + (city) + " **********");
        officeDAO.findByCityIgnoreCase(city).forEach(System.out::println);
    }

    public Office findById(Long id) throws ItemNotFoundException{
        return officeDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public List<Office> findByCity(String city) {
        List<Office> offices = officeDAO.findByCityIgnoreCase(city);
        offices.forEach(office -> office.getWorkStations().size());
        return offices;
    }
}
