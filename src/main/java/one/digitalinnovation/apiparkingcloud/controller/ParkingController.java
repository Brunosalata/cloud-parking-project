package one.digitalinnovation.apiparkingcloud.controller;

import one.digitalinnovation.apiparkingcloud.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @GetMapping
    public List<Parking> findAll() {
        var parking = new Parking();
        parking.setColor("Branco");
        parking.setLicense("FGZ-8765");
        parking.setModel("GOL GIV");
        parking.setState("SP");

        return Arrays.asList(parking);
    }

}
