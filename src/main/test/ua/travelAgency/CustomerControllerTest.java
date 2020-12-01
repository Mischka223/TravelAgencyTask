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
import com.softserve.travelAgency.HotelService.HotelService;
import com.softserve.travelAgency.config.SpringConfig;
import com.softserve.travelAgency.model.Apartment;
import com.softserve.travelAgency.model.Hotel;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringConfig.class)
public class CustomerControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private HotelService hotelService;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void addHotelTest() {
        Hotel hotel = prepareHotel();
        Hotel hotelToAdd = hotelService.addHotel(hotel);
        Hotel foundHotel = hotelService.getHotelById(hotelToAdd.getId());
        Assert.assertNotNull(foundHotel);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void removeHotelTest() {
        Hotel hotel = prepareHotel();
        Hotel hotelToAdd = hotelService.addHotel(hotel);
        hotelService.removeHotel(hotelToAdd.getId());

        Hotel foundHotel = hotelService.getHotelById(hotelToAdd.getId());
        Assert.assertNull(foundHotel);
    }

    @Test
    public void addApartmentToHotel() {
        Hotel hotel = prepareHotel();
        Hotel hotelToAdd = hotelService.addHotel(hotel);

        Apartment apartment = prepareApartment();
        hotelService.createApartment(hotelToAdd.getId(), apartment);

    }

    private Apartment prepareApartment() {
        Apartment apartment = new Apartment();
        apartment.setDescription("Apartment Description");
        apartment.setName("Apartment Name");

        return apartment;
    }

    private Hotel prepareHotel() {
        Hotel hotelToSave = new Hotel();
        hotelToSave.setCountry("Ukraine");
        hotelToSave.setDescription("Description");
        hotelToSave.setName("BankHotel");
        return hotelToSave;
    }
}