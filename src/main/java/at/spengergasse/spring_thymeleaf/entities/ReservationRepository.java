package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByDeviceIdAndReservationTime(String deviceId, LocalDateTime reservationTime);


    List<Reservation> findByPatientNameAndReservationTime(String patientName, LocalDateTime reservationTime);

}