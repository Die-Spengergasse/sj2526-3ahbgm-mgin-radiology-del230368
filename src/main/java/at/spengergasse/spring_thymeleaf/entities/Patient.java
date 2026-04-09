package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "p_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Svnummer", unique = true, nullable = false)
    private String svnummer;

    @Column(name = "Vorname")
    private String vorname;

    @Column(name = "Nachname")
    private String nachname;

    @Column(name = "Geschlecht")
    private String geschlecht;  // "Männlich", "Weiblich", "Divers"

    @Column(name = "Geburtsdatum")
    private LocalDate geburtsdatum;

    public Patient() {}
    public Patient(Long id, String svnummer, String vorname, String nachname,
                   String geschlecht, LocalDate geburtsdatum) {
        this.id = id;
        this.svnummer = svnummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.geburtsdatum = geburtsdatum;
    }

    public String getVollerName() {
        return vorname + " " + nachname;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSvnummer() { return svnummer; }
    public void setSvnummer(String svnummer) { this.svnummer = svnummer; }
    public String getVorname() { return vorname; }
    public void setVorname(String vorname) { this.vorname = vorname; }
    public String getNachname() { return nachname; }
    public void setNachname(String nachname) { this.nachname = nachname; }
    public String getGeschlecht() { return geschlecht; }
    public void setGeschlecht(String geschlecht) { this.geschlecht = geschlecht; }
    public LocalDate getGeburtsdatum() { return geburtsdatum; }
    public void setGeburtsdatum(LocalDate geburtsdatum) { this.geburtsdatum = geburtsdatum; }

    @Override
    public String toString() {
        return "Patient{id=" + id + ", svnummer='" + svnummer + "', vorname='" + vorname +
                "', nachname='" + nachname + "', geschlecht='" + geschlecht +
                "', geburtsdatum=" + geburtsdatum + '}';
    }
}