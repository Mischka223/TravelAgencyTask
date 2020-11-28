package ua.travelAgency.model;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "hotel_id")
    private int hotelId;
    @Column(name = "description")
    private String description;
    @Column(name = "rooms")
    private int rooms;


    public Apartment(String name, String description, int rooms) {
        this.name = name;
        this.description = description;
        this.rooms = rooms;
    }
    public Apartment(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
