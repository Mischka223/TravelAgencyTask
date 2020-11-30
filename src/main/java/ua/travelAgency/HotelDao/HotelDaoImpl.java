package ua.travelAgency.HotelDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.travelAgency.model.Apartment;
import ua.travelAgency.model.Country;
import ua.travelAgency.model.Hotel;

import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {

    private final SessionFactory sessionFactory;

    public HotelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;

    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        Session session = getCurrentSession();
        session.save(hotel);
        System.out.println("Hotel successfully saved. Hotel details: " + hotel);
        return hotel;
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        Session session = getCurrentSession();
        session.update(hotel);
        System.out.println("Book successfully update.  Book details " + hotel);
        return hotel;
    }

    @Override
    public void removeHotel(int id) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);

        if (hotel != null) {
            session.remove(hotel);
        }
        System.out.println("Hotel successfully delete. Hotel details: " + hotel);
    }

    @Override
    public Hotel getHotelById(int id) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);
        System.out.println("Hotel successfully loaded.Hotel details" + hotel);
        return hotel;
    }

    @Override
    public List<Hotel> listHotels() {
        Session session = getCurrentSession();
        List<Hotel> hotelList = session.createQuery("From Hotel").list();
        for (Hotel hotel : hotelList) {
            System.out.println("Hotel list :" + hotel);
        }
        return hotelList;
    }

    @Override
    public List<Country> countryList() {
        Session session = getCurrentSession();
        List<Country> countries = session.createQuery("FROM  Country ").list();
        for (Country country : countries){
            System.out.println("Country list : " + country);
        }
        return countries;
    }

    public Apartment createApartment(int id, Apartment apartment) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);
        session.save(apartment);
        hotel.getApartmentList().add(apartment);
        apartment.setHotel(hotel);
        session.save(hotel);
        System.out.println("Apartment successfully create. Apartment details:  " + apartment);
        return apartment;
    }

    public List<Apartment> removeApartment(int id) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);
        if (hotel.getApartmentList().get(id) != null) {
            hotel.getApartmentList().remove(id);
        }
        session.save(hotel);

        System.out.println("Hotel successfully delete. Hotel details: " + hotel.getApartmentList().get(id));
        return hotel.getApartmentList();
    }
    @Override
    public List<Apartment> apartmentList(int id){
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class,id);
        List<Apartment> apartments = hotel.getApartmentList();
        return apartments;
    }
}

