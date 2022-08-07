package one.digitalinnovation.apiparkingcloud.controller.mapper;

import one.digitalinnovation.apiparkingcloud.controller.dto.ParkingDTO;
import one.digitalinnovation.apiparkingcloud.model.Parking;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO parkingDTO(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return null;
    }
}
