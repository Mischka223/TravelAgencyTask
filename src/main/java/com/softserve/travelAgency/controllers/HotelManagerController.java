package com.softserve.travelAgency.controllers;

import com.softserve.travelAgency.model.Apartment;
import com.softserve.travelAgency.model.Hotel;
import com.softserve.travelAgency.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class HotelManagerController {


    public static final String CREATE_HOTEL = "/admin/createHotel";
    public static final String LIST_HOTEL = "redirect:/list/hotel";


    private final HotelService hotelService;

    public HotelManagerController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping("/create/hotel")
    public String createHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("countries", hotelService.countryList());
        return CREATE_HOTEL;
    }

    @PostMapping("/create/hotel")
    public String createNewHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.addHotel(hotel);
        return LIST_HOTEL;
    }

    @PostMapping("/delete/hotel/{id}")
    public String deleteHotel(@PathVariable("id") Integer id) {
        hotelService.removeHotel(id);
        return LIST_HOTEL;

    }


    @GetMapping("/edit/hotel/{id}")
    public String editHotel(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        model.addAttribute("countries", hotelService.countryList());
        return "/admin/editHotel";
    }

    @PostMapping("/edit/hotel/{id}")
    public String updateHotel(@PathVariable("id") Integer id,
                              @ModelAttribute("hotel") Hotel hotel) {
        hotelService.getHotelById(id);
        hotelService.updateHotel(hotel);
        return LIST_HOTEL;
    }

    @GetMapping("/hotel/{id}/create/apartment")
    public String createApartment(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        model.addAttribute("apartment", new Apartment());
        System.out.println(model);
        return "admin/createApartment";
    }

    @PostMapping("/hotel/{id}/create/apartment")
    public String createNewApartment(@ModelAttribute("apartment") Apartment apartment,
                                     @PathVariable("id") Integer id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        hotelService.createApartment(id, apartment);
        return LIST_HOTEL;
    }


    @PostMapping("hotel/{hotelId}/apartment/{apartmentId}/delete")
    public String deleteApartment(@PathVariable("hotelId") Integer hotelId,
                                  @PathVariable("apartmentId") Integer apartmentId) {
        hotelService.removeApartment(hotelId, apartmentId);

        return LIST_HOTEL;
    }

    @GetMapping("hotel/{hotelId}/apartment/{apartmentId}/edit")
    public String editApartment(@PathVariable("hotelId") Integer hotelId,
                                @PathVariable("apartmentId") Integer apartmentId,
                                Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(hotelId));
        model.addAttribute("apartment", hotelService.getApartmentById(apartmentId, hotelId));

        return "/admin/editApartment";
    }

    @PostMapping("hotel/{hotelId}/apartment/{apartmentId}/edit")
    public String updateApartment(@PathVariable("hotelId") Integer hotelId,
                                  @PathVariable("apartmentId") Integer apartmentId,
                                  @ModelAttribute("apartment") Apartment apartment) {
        hotelService.updateApartment(apartmentId, hotelId, apartment);

        return LIST_HOTEL;
    }
}
