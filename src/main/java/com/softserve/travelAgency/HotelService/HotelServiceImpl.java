package com.softserve.travelAgency.HotelService;

import com.softserve.travelAgency.model.Apartment;
import com.softserve.travelAgency.model.Country;
import com.softserve.travelAgency.model.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.softserve.travelAgency.HotelDao.HotelDao;

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

    public Apartment getApartmentById(Integer hotelId, Integer apartmentId) {
        return hotelDao.getApartmentById(hotelId, apartmentId);
    }

    public void removeApartment(Integer hotelId, Integer apartmentId) {
        hotelDao.removeApartment(hotelId, apartmentId);
    }

    public void updateApartment(Integer hotelId, Integer apartmentId) {
        hotelDao.updateApartment(hotelId, apartmentId);
    }

    @Override
    public List<Country> countryList() {
        return hotelDao.countryList();
    }

    @Override
    public List<Apartment> apartmentList(Integer id) {
        return hotelDao.apartmentList(id);
    }
}
