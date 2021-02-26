package com.humanbooster.examRest.repositories;

import com.humanbooster.examRest.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    @Override
    List<Car> findAll();
}
