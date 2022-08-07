package one.digitalinnovation.apiparkingcloud.service;

import one.digitalinnovation.apiparkingcloud.model.Parking;

import java.time.LocalDateTime;

public class ParkingCheckOut {

    public static Double getBill(Parking parking) {
        return getBill(parking.getEntryDate(), parking.getExitDate());
    }

    private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
        return null;
    }

}
