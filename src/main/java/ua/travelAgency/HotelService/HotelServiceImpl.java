package ua.travelAgency.HotelService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.travelAgency.HotelDao.HotelDao;
import ua.travelAgency.model.Apartment;
import ua.travelAgency.model.Country;
import ua.travelAgency.model.Hotel;

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
    public void removeHotel(int id) {
        hotelDao.removeHotel(id);
    }

    @Override
    public Hotel getHotelById(int id) {
        return hotelDao.getHotelById(id);
    }

    @Override
    public List<Hotel> listHotels() {
        return hotelDao.listHotels();
    }

    @Override
    public Apartment createApartment(int id,Apartment apartment) {
        return hotelDao.createApartment(id,apartment);
    }

    @Override
    public List<Country> countryList() {
        return hotelDao.countryList();
    }
}