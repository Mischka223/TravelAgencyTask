package travelAgency.HotelService;

import travelAgency.model.Apartment;
import travelAgency.model.Country;
import travelAgency.model.Hotel;

import java.util.List;

public interface HotelService {
    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(Hotel hotel);

    void removeHotel(Integer id);

    Hotel getHotelById(Integer id);

    List<Hotel> listHotels();

    Apartment createApartment(Integer id, Apartment apartment);

    Apartment getApartmentById(Integer hotelId, Integer apartmentId);

    void removeApartment(Integer hotelId, Integer apartmentId);

    void updateApartment(Integer hotelId, Integer apartmentId);

    List<Country> countryList();

    List<Apartment> apartmentList(Integer id);

}
