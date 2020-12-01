package travelAgency.model;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "typeOfApartment")
    private String typeOfApartment;
    @Column(name = "price")
    private int price;
    @Column(name = "description")
    private String description;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Apartment(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Apartment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfApartment() {
        return typeOfApartment;
    }

    public void setTypeOfApartment(String typeOfApartment) {
        this.typeOfApartment = typeOfApartment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOfApartment='" + typeOfApartment + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
