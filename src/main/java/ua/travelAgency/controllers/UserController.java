package ua.travelAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.travelAgency.HotelService.HotelService;

@Controller
@RequestMapping("/user")
public class UserController {


    private final HotelService hotelService;

    public UserController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    //Основна сторінка
    @GetMapping("/home")
    public String HomePage() {
        return "admin/HomeManagerPage   ";
    }

    //Сторінка всіх готелів
    @GetMapping("/list/hotel")
    public String listHotel(Model model) {
        model.addAttribute("hotels", hotelService.listHotels());
        return "user/allHotel";
    }


    //Окремий готель
    @GetMapping("/hotel/{id}")
    public String showHotel(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        model.addAttribute("apartments", hotelService.apartmentList(id));
        return "user/showHotel";
    }

    @GetMapping("/hotel/{id}/apartments")
    public String apartmentList(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("apartments", hotelService.apartmentList(id));
        return "user/allApartmentInHotel";
    }

}
