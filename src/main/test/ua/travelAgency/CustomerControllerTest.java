package ua.travelAgency;

import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.travelAgency.HotelDao.HotelDaoImpl;
import ua.travelAgency.config.SpringConfig;
import ua.travelAgency.model.Hotel;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringConfig.class)
public class CustomerControllerTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private HotelDaoImpl hotelDao;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void addHotelTest() {
        Hotel hotel = prepareHotel();
        Hotel hotelToAdd = hotelDao.addHotel(hotel);
        Hotel foundHotel = hotelDao.getHotelById(hotelToAdd.getId());
        Assert.assertNotNull(foundHotel);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void removeHotelTest() {
        Hotel hotel = prepareHotel();
        Hotel hotelToAdd = hotelDao.addHotel(hotel);
        hotelDao.removeHotel(hotelToAdd.getId());

        Hotel foundHotel = hotelDao.getHotelById(hotelToAdd.getId());
        Assert.assertNull(foundHotel);
    }

    private Hotel prepareHotel() {
        Hotel hotelToSave = new Hotel();
        hotelToSave.setCountry("Ukraine");
        hotelToSave.setDescription("Description");
        hotelToSave.setName("BankHotel");
        return hotelToSave;
    }
}