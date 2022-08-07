package one.digitalinnovation.apiparkingcloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.apiparkingcloud.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.apiparkingcloud.controller.dto.ParkingDTO;
import one.digitalinnovation.apiparkingcloud.controller.mapper.ParkingMapper;
import one.digitalinnovation.apiparkingcloud.model.Parking;
import one.digitalinnovation.apiparkingcloud.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {           //poderia ter usado @Autowired acima do ParkingService
        this.parkingService = parkingService;                           //mas o recomendado é utilizar um construtor (ao lado)
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    //public List<Parking> findAll() {
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);       //retorno vai ser um ResponseEntity.ok (retorna código 200) com result como corpo
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);       //retorno vai ser um ResponseEntity.ok (retorna código 200) com result como corpo
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {       //Recebe um objeto com menos informação (ParkingCreatedto) e retorna um objeto completo
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto) {       //Recebe um objeto com menos informação (ParkingCreatedto) e retorna um objeto completo
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.update(id, parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
