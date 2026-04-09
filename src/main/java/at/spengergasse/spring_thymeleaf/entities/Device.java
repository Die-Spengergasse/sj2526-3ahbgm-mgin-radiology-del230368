package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bezeichnung")
    private int id;
    @Column(name = "type")
    private String type;
    @Column(name= "Raumnummer")
    private int raumnummer;

    public Device() {}
    public Device(int id, String type, int raumnummer) {
        this.id = id;
        this.type = type;
        this.raumnummer = raumnummer;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", raumnummer=" + raumnummer +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getRaumnummer() {
        return raumnummer;
    }
    public void setRaumnummer(int raumnummer) {
        this.raumnummer = raumnummer;
    }
}
