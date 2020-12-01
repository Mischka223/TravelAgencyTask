package com.softserve.travelAgency.dao;

import com.softserve.travelAgency.model.Apartment;
import com.softserve.travelAgency.model.Country;
import com.softserve.travelAgency.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

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
    public void removeHotel(Integer id) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);

        if (hotel != null) {
            session.remove(hotel);
        }
        System.out.println("Hotel successfully delete. Hotel details: " + hotel);
    }

    @Override
    public Hotel getHotelById(Integer id) {
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
        System.out.println("Apartment successfully create. Apartment details:  " + apartment);
        return apartment;
    }

    public Apartment getApartmentById(Integer hotelId, Integer apartmentId) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, hotelId);
        hotel.getApartmentList().get(apartmentId);
        return hotel.getApartmentList().get(apartmentId);
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
    public void updateApartment(Integer hotelId, Integer apartmentId) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, hotelId);
        List<Apartment> apartments = hotel.getApartmentList();
        Apartment apartment = apartments.stream()
                .filter(apart -> apart.getId().equals(apartmentId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("apartment by id " + apartmentId + "not found"));
        session.update(apartment);

    }

    @Override
    public List<Apartment> apartmentList(Integer id) {
        Session session = getCurrentSession();
        Hotel hotel = session.load(Hotel.class, id);
        List<Apartment> apartments = hotel.getApartmentList();
        return apartments;
    }

}

