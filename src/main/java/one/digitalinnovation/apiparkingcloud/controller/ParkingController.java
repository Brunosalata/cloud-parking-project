package one.digitalinnovation.apiparkingcloud.controller;

import one.digitalinnovation.apiparkingcloud.controller.dto.ParkingDTO;
import one.digitalinnovation.apiparkingcloud.controller.mapper.ParkingMapper;
import one.digitalinnovation.apiparkingcloud.model.Parking;
import one.digitalinnovation.apiparkingcloud.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService) {           //poderia ter usado @Autowired acima do ParkingService
        this.parkingService = parkingService;                           //mas o recomendado é utilizar um construtor (ao lado)
    }

    @GetMapping
    //public List<Parking> findAll() {
    public List<ParkingDTO> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
    }

}
