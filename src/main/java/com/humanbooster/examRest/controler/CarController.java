package com.humanbooster.examRest.controler;

import com.humanbooster.examRest.model.Car;
import com.humanbooster.examRest.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping(value ="", produces = {"application/json"})
    List<Car> getAll(){
        return carRepository.findAll();
    }

    @PostMapping(value = "", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car){

        this.carRepository.save(car);
        return new ResponseEntity<Car>(car, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{car}", produces = {"application/json"})
    Car getOneCar(@PathVariable(name = "car", required = false) Car car){
        if(car == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Voiture introuvable");
        }else{
            return car;
        }
    }
}
