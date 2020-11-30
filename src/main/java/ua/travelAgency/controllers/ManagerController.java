package ua.travelAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.travelAgency.HotelService.HotelService;
import ua.travelAgency.model.Apartment;
import ua.travelAgency.model.Hotel;


@Controller
@RequestMapping("/admin")
public class ManagerController {

    private final HotelService hotelService;

    public ManagerController(HotelService hotelService) {
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
        return "admin/allHotel";
    }

    //Сторінка шаблону готелю
    @GetMapping("/create/hotel")
    public String createHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("countries",hotelService.countryList());

        return "admin/createHotel";
    }

    //Пост метод для шаблону
    @PostMapping("/create/hotel")
    public String createNewHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.addHotel(hotel);
        return "redirect:/home";
    }

    //Видалення готелю по id
    @PostMapping("/delete/hotel/{id}")
    public String deleteHotel(@PathVariable("id") int id) {
        hotelService.removeHotel(id);
        return "redirect:/admin/list/hotel";

    }

    //Окремий готель
    @GetMapping("/hotel/{id}")
    public String showHotel(@PathVariable("id") int id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        model.addAttribute("apartments",hotelService.apartmentList(id));
        return "admin/showHotel";
    }

    //шаблон для зміни готелю
    @GetMapping("/edit/hotel/{id}")
    public String editHotel(@PathVariable("id") int id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        model.addAttribute("countries",hotelService.countryList());
        return "admin/editHotel";
    }

    //Зміна параметрів готелю
    @PostMapping("/edit/hotel/{id}")
    public String updateHotel(@PathVariable("id") int id,
                              @ModelAttribute("hotel") Hotel hotel) {
        hotelService.getHotelById(id);
        hotelService.updateHotel(hotel);
        return "redirect:/admin/list/hotel";
    }
    @GetMapping("/hotel/{id}/create/apartment")
    public String createApartment(@PathVariable("id") int id, Model model){
        model.addAttribute("hotel",hotelService.getHotelById(id));
        model.addAttribute("apartment",new Apartment());

        System.out.println(model);
        return "admin/createApartment";
    }
    @PostMapping("/hotel/{id}/create/apartment")
    public String createApartment2(@ModelAttribute("apartment") Apartment apartment,
                                   @PathVariable("id") int id, Model model){
        model.addAttribute("hotel",hotelService.getHotelById(id));
        hotelService.createApartment(id,apartment);
        return "redirect:/admin/list/hotel";
   }
   @GetMapping("/hotel/{id}/apartments")
    public String apartmentList(@PathVariable("id") int id,Model model){
        model.addAttribute("apartments",hotelService.apartmentList(id));
        return "admin/allApartmentInHotel";
   }

}
