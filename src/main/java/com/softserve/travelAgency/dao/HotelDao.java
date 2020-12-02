package com.softserve.travelAgency.dao;

import com.softserve.travelAgency.model.Apartment;
import com.softserve.travelAgency.model.Country;
import com.softserve.travelAgency.model.Hotel;

import java.util.List;

public interface HotelDao {
    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(Hotel hotel);

    void removeHotel(Integer id);

    Hotel getHotelById(Integer id);

    List<Hotel> listHotels();

    Apartment createApartment(Integer id, Apartment apartment);

    Apartment getApartmentById(Integer apartmentId, Integer hotelId);

    void removeApartment(Integer hotelId, Integer apartmentId);

    void updateApartment(Integer apartmentId, Integer hotelId, Apartment apartment);


    List<Country> countryList();

    List<Apartment> apartmentList(Integer id);


}
