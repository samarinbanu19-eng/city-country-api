package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return service.getCountries();
    }

    @GetMapping("/countries/{countryId}/cities")
    public Page<City> getCities(
            @PathVariable Long countryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return service.getCitiesByCountry(countryId, page, size);
    }

    @GetMapping("/cities/{cityId}")
    public City getCity(@PathVariable Long cityId) {
        return service.getCityById(cityId);
    }
}