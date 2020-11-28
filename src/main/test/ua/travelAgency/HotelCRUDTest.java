package ua.travelAgency;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.travelAgency.HotelDao.HotelDaoInterface;
import ua.travelAgency.config.HibernateConfig;
import ua.travelAgency.config.SpringConfig;
import ua.travelAgency.model.Hotel;

@RunWith(SpringJUnit4ClassRunner.class)
public class HotelCRUDTest {

    @Autowired
    private HotelDaoInterface hotelDaoInterface;

    @Test
    public void addHotelTest(){
        Hotel hotelToSave = prepareHotel();
        Hotel hotel = hotelDaoInterface.addHotel(hotelToSave);
        Hotel foundHotel = hotelDaoInterface.getHotelById(hotel.getId());
        Assert.assertNotNull(foundHotel);
    }

    private Hotel prepareHotel() {
        Hotel hotelToSave = new Hotel();
        hotelToSave.setCountry("Ukraine");
        hotelToSave.setDescription("Description");
        hotelToSave.setName("BankHotel");
        return hotelToSave;
    }
}
