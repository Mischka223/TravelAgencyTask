package com.softserve.travelAgency.service;

import com.softserve.travelAgency.dao.HotelDao;
import com.softserve.travelAgency.model.Apartment;
import com.softserve.travelAgency.model.Country;
import com.softserve.travelAgency.model.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private final HotelDao hotelDao;

    public HotelServiceImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelDao.addHotel(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelDao.updateHotel(hotel);
    }

    @Override
    public void removeHotel(Integer id) {
        hotelDao.removeHotel(id);
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return hotelDao.getHotelById(id);
    }

    @Override
    public List<Hotel> listHotels() {
        return hotelDao.listHotels();
    }

    @Override
    public Apartment createApartment(Integer id, Apartment apartment) {
        return hotelDao.createApartment(id, apartment);
    }

    @Override
    public Apartment getApartmentById(Integer apartmentId, Integer hotelId) {
        return hotelDao.getApartmentById(apartmentId, hotelId);
    }


    public void removeApartment(Integer hotelId, Integer apartmentId) {
        hotelDao.removeApartment(hotelId, apartmentId);
    }

    public void updateApartment(Integer apartmentId, Integer hotelId, Apartment apartment) {
        hotelDao.updateApartment(apartmentId, hotelId, apartment);
    }

    @Override
    public List<Apartment> apartmentList(Integer id) {
        return hotelDao.apartmentList(id);
    }

    @Override
    public List<Country> countryList() {
        return hotelDao.countryList();
    }
}


