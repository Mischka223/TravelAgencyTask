package ua.travelAgency.HotelService;

import ua.travelAgency.model.Apartment;
import ua.travelAgency.model.Country;
import ua.travelAgency.model.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel addHotel(Hotel hotel);

    public Hotel updateHotel(Hotel hotel);

    public void removeHotel(int id);

    public Hotel getHotelById(int id);

    public List<Hotel> listHotels();

    public Apartment createApartment(int id, Apartment apartment);

    public List<Country> countryList();

}
