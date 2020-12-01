package ua.travelAgency;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.softserve.travelAgency.dao.HotelDao;
import com.softserve.travelAgency.model.Hotel;

@RunWith(SpringJUnit4ClassRunner.class)
public class HotelCRUDTest {

    @Autowired
    private HotelDao hotelDao;

    @Test
    public void addHotelTest(){
        Hotel hotelToSave = prepareHotel();
        Hotel hotel = hotelDao.addHotel(hotelToSave);
        Hotel foundHotel = hotelDao.getHotelById(hotel.getId());
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
