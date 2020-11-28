package ua.travelAgency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.travelAgency.HotelDao.HotelDaoInterface;
import ua.travelAgency.model.Hotel;


@Controller
@RequestMapping("/admin")
public class ManagerController {

    private final HotelDaoInterface hotelDao;

    public ManagerController(HotelDaoInterface hotelDao) {
        this.hotelDao = hotelDao;
    }
//Основна сторінка
    @GetMapping("/home")
    public String HomePage(){
        return "admin/HomePageManager";
    }
//Сторінка всіх готелів
 @GetMapping("/list/hotel")
    public String listHotel(Model model){
        model.addAttribute("hotels", hotelDao.listHotels());
        return "admin/allHotel";
    }
//Сторінка шаблону готелю
    @GetMapping("/create/hotel")
    public String createHotel(Model model){
        model.addAttribute("hotel",new Hotel());
        System.out.println("create new hotel" + model);
        return "admin/createHotel";
    }
//Пост метод для шаблону
    @PostMapping("/create/hotel")
    public String createNewHotel(@ModelAttribute("hotel") Hotel hotel){
        hotelDao.addHotel(hotel);
        return "redirect:/home";
    }
//Видалення готелю по id
    @PostMapping("/delete/hotel/{id}")
    public String deleteHotel(@PathVariable("id") int id){
        hotelDao.removeHotel(id);
        return "redirect:/admin/list/hotel";

    }
//Окремий готель
    @GetMapping("/hotel/{id}")
    public String showHotel(@PathVariable("id") int id,Model model){
        model.addAttribute("hotel",hotelDao.getHotelById(id));
        return "admin/showHotel";
    }

}
