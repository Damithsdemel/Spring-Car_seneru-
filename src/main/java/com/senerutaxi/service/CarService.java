package com.senerutaxi.service;

import com.senerutaxi.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    List<Car> newCars();

    Car findById(Long id);

    void save(Car car);
}
