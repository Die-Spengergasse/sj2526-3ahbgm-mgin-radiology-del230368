package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final DeviceRepository deviceRepository;

    public ReservationController(ReservationRepository reservationRepository,
                                 PatientRepository patientRepository,
                                 DeviceRepository deviceRepository) {
        this.reservationRepository = reservationRepository;
        this.patientRepository = patientRepository;
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/add")
    public String add(Model model) {

        List<String> patientNames = new ArrayList<>();
        for (Patient p : patientRepository.findAll()) {
            patientNames.add(p.getFirstName() + " " + p.getSurname());
        }

        model.addAttribute("reservation", new Reservation());
        model.addAttribute("patients", patientNames);
        model.addAttribute("devices", deviceRepository.findAll());

        return "add_reservation";
    }


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservation_list";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Reservation reservation, Model model) {

        if (reservation.getReservationTime().isBefore(java.time.LocalDateTime.now())) {
            model.addAttribute("error", "Termin liegt in der Vergangenheit!");
            model.addAttribute("reservation", reservation);
            return "add_reservation";
        }

        try {
            reservationRepository.save(reservation);
        } catch (Exception e) {
            model.addAttribute("error", "DB Fehler!");
            model.addAttribute("reservation", reservation);
            return "add_reservation";
        }

        return "redirect:/reservation/list";
    }
}