package ua.travelAgency.HotelDao;

import ua.travelAgency.model.Hotel;

import java.util.List;

public interface HotelDaoInterface {
    public Hotel addHotel(Hotel hotel);
    public void updateHotel(Hotel hotel );
    public void removeHotel(int id);
    public  Hotel getHotelById(int id);
    public List<Hotel> listHotels();

}
