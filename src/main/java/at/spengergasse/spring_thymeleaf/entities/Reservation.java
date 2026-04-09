package at.spengergasse.spring_thymeleaf.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "test")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "patient_id")
    private int patientId;
    @Column(name = "device_id")
    private int deviceId;
    @Column(name = "untersuchungszeit")
    private LocalDateTime untersuchungszeit;
    @Column(name = "koerperregion")
    private String koerperregion;  // "Kopf", "Hals", "Thorax", ...
    @Column(name = "kommentar", length = 1000)
    private String kommentar;

    public Reservation() {}
    public Reservation(int id, int patientId, int deviceId, LocalDateTime untersuchungszeit,
                       String koerperregion, String kommentar) {
        this.id = id;
        this.patientId = patientId;
        this.deviceId = deviceId;
        this.untersuchungszeit = untersuchungszeit;
        this.koerperregion = koerperregion;
        this.kommentar = kommentar;
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", deviceId=" + deviceId +
                ", untersuchungszeit=" + untersuchungszeit +
                ", koerperregion='" + koerperregion + '\'' +
                ", kommentar='" + kommentar + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getUntersuchungszeit() {
        return untersuchungszeit;
    }

    public void setUntersuchungszeit(LocalDateTime untersuchungszeit) {
        this.untersuchungszeit = untersuchungszeit;
    }

    public String getKoerperregion() {
        return koerperregion;
    }

    public void setKoerperregion(String koerperregion) {
        this.koerperregion = koerperregion;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
