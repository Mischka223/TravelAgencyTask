package com.softserve.travelAgency.controllers;

import com.softserve.travelAgency.model.Hotel;
import com.softserve.travelAgency.model.Permission;
import com.softserve.travelAgency.service.HotelService;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final HotelService hotelService;

    public UserController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Hotel> hotels = hotelService.listHotels();
        Set<String> countries = hotels.stream().map(Hotel::getCountry).collect(Collectors.toSet());
        model.addAttribute("countries", countries);
        return "admin/home";
    }


    @GetMapping("/list/hotel")
    public String listHotel(@RequestParam(value = "country", required = false) String country,
                            @CurrentSecurityContext SecurityContext securityContext,
                            Model model) {
        List<Hotel> hotels = hotelService.listHotels().stream().filter(hotel -> country == null || country.equalsIgnoreCase(hotel.getCountry())).collect(Collectors.toList());
        Set<String> countries = hotels.stream().map(Hotel::getCountry).collect(Collectors.toSet());
        model.addAttribute("country", countries);
        model.addAttribute("hotels", hotels);
        hasWritePermission(securityContext, model);
        return "user/allHotel";
    }

    private void hasWritePermission(@CurrentSecurityContext SecurityContext securityContext, Model model) {
        model.addAttribute("hasWritePermission", securityContext.getAuthentication()
                .getAuthorities().stream()
                .anyMatch(grantedAuthority -> Permission.PERSON_WRITE.getPermission().equals(grantedAuthority.getAuthority())));
    }


    @GetMapping("/hotel/{id}")
    public String showHotel(@CurrentSecurityContext SecurityContext securityContext,
                            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        model.addAttribute("apartments", hotelService.apartmentList(id));
        hasWritePermission(securityContext, model);
        return "user/showHotel";
    }

    @GetMapping("/hotel/{id}/apartments")
    public String apartmentList(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("apartments", hotelService.apartmentList(id));
        return "user/allApartmentInHotel";
    }

}
