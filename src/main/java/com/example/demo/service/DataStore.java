
package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataStore {

    public List<Country> countries = List.of(
            new Country(1L, "India"),
            new Country(2L, "France")
    );

    public List<City> cities = List.of(
            new City(1L, "Hyderabad", 1L, "Tech City"),
            new City(2L, "Mumbai", 1L, "Finance City"),
            new City(3L, "Paris", 2L, "Capital City"),
            new City(4L, "Nice", 2L, "Tourist City")
    );
}