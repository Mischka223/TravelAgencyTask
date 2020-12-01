package ua.travelAgency.HotelService;

import ua.travelAgency.model.Apartment;
import ua.travelAgency.model.Country;
import ua.travelAgency.model.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel addHotel(Hotel hotel);

    public Hotel updateHotel(Hotel hotel);

    public void removeHotel(Integer id);

    public Hotel getHotelById(Integer id);

    public List<Hotel> listHotels();

    public Apartment createApartment(Integer id, Apartment apartment);

    public Apartment getApartmentById(Integer hotelId, Integer apartmentId);

    public List<Apartment> removeApartment(Integer hotelId, Integer apartmentId);

    public Apartment updateApartment(Integer hotelId, Integer apartmentId);

    public List<Country> countryList();

    public List<Apartment> apartmentList(Integer id);

}
