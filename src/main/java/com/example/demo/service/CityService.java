package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private DataStore dataStore;

    public List<Country> getCountries() {
        return dataStore.countries;
    }

    public Page<City> getCitiesByCountry(Long countryId, int page, int size) {

        List<City> filtered = dataStore.cities.stream()
                .filter(city -> city.getCountryId().equals(countryId))
                .toList();

        int start = Math.min(page * size, filtered.size());
        int end = Math.min(start + size, filtered.size());

        List<City> paginated = filtered.subList(start, end);

        return new PageImpl<>(paginated, PageRequest.of(page, size), filtered.size());
    }

    public City getCityById(Long id) {
        return dataStore.cities.stream()
                .filter(city -> city.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("City not found"));
    }
}