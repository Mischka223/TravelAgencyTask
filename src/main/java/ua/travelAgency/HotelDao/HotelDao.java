package ua.travelAgency.HotelDao;

import ua.travelAgency.model.Hotel;

import java.util.List;

public interface HotelDao {
    public Hotel addHotel(Hotel hotel);

    public Hotel updateHotel(Hotel hotel);

    public void removeHotel(int id);

    public Hotel getHotelById(int id);

    public List<Hotel> listHotels();

}
