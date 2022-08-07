package one.digitalinnovation.apiparkingcloud.repository;

import one.digitalinnovation.apiparkingcloud.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRespository extends JpaRepository<Parking, String> {
}
