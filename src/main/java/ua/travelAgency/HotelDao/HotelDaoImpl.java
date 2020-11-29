package ua.travelAgency.HotelDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.travelAgency.model.Hotel;

import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDaoInterface {

    private final SessionFactory sessionFactory;

    public HotelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        this.sessionFactory.openSession();
        return this.sessionFactory.getCurrentSession();

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
}
