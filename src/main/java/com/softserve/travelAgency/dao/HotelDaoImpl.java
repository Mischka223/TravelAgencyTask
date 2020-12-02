package com.softserve.travelAgency.dao;

import com.softserve.travelAgency.model.Apartment;
import com.softserve.travelAgency.model.Country;
import com.softserve.travelAgency.model.Hotel;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class HotelDaoImpl implements HotelDao {

    private static final Logger log = Logger.getLogger(HotelDaoImpl.class.getName());

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
        log.info("Hotel successfully saved. Hotel details: " + hotel);
        return hotel;
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        Session session = getCurrentSession();
        session.update(hotel);
        log.info("Book successfully update.  Book details " + hotel);
        return hotel;
    }

    @Override
    public void removeHotel(Integer id) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);

        if (hotel != null) {
            session.remove(hotel);
        }
        log.info("Hotel successfully delete. Hotel details: " + hotel);
    }

    @Override
    public Hotel getHotelById(Integer id) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);
        log.info("Hotel successfully loaded.Hotel details" + hotel);
        return hotel;
    }

    @Override
    public List<Hotel> listHotels() {
        Session session = getCurrentSession();
        List<Hotel> hotelList = session.createQuery("From Hotel").list();
        for (Hotel hotel : hotelList) {
            log.info("Hotel list :" + hotel);
        }
        return hotelList;
    }

    @Override
    public List<Country> countryList() {
        Session session = getCurrentSession();
        List<Country> countries = session.createQuery("FROM  Country ").list();
        for (Country country : countries) {
            System.out.println("Country list : " + country);
        }
        return countries;
    }

    public Apartment createApartment(Integer id, Apartment apartment) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);
        session.save(apartment);
        hotel.getApartmentList().add(apartment);
        apartment.setHotel(hotel);
        session.save(hotel);
        log.info("Apartment successfully create. Apartment details:  " + apartment);
        return apartment;
    }

    @Override
    public Apartment getApartmentById(Integer apartmentId, Integer hotelId) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, hotelId);
        List<Apartment> apartments = hotel.getApartmentList();
        return apartments.stream()
                .filter(apart -> apart.getId().equals(apartmentId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("apartment by id " + apartmentId + "not found"));
    }


    @Override
    public void removeApartment(Integer hotelId, Integer apartmentId) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, hotelId);
        List<Apartment> apartments = hotel.getApartmentList();
        Apartment apartment = apartments.stream()
                .filter(apart -> apart.getId().equals(apartmentId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("apartment by id " + apartmentId + "not found"));
        session.remove(apartment);
    }

    @Override
    public void updateApartment(Integer apartmentId, Integer hotelId, Apartment apartment) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, hotelId);
        apartment.setId(apartmentId);
        apartment.setHotel(hotel);
        session.update(apartment);

    }

    @Override
    public List<Apartment> apartmentList(Integer id) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);
        return hotel.getApartmentList();
    }

}

