package com.humanbooster.examRest.controler;

import com.humanbooster.examRest.model.Car;
import com.humanbooster.examRest.model.Color;
import com.humanbooster.examRest.repositories.CarRepository;
import com.humanbooster.examRest.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @GetMapping(value ="", produces = {"application/json"})
    List<Color> getAll(){
        return colorRepository.findAll();
    }

    @PostMapping(value = "", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Color> createCar(@Valid @RequestBody Color color){

        this.colorRepository.save(color);
        return new ResponseEntity<Color>(color, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{color}", produces = {"application/json"})
    void deleteColor(@PathVariable(name = "color", required = false) Color color){
        if(color == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colour introuvable");
        }else{
            this.colorRepository.delete(color);
        }
    }

    @PutMapping(value = "/{color}", produces = "application/json")
    public ResponseEntity<Color> editColor(@PathVariable(name = "color", required = false) Color color,
                                                 @Valid @RequestBody Color colorUpdated){
        if(color == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couleur Introuvable");
        }

        colorUpdated.setId(color.getId());
        this.colorRepository.save(colorUpdated);

        return new ResponseEntity<Color>(colorUpdated, HttpStatus.CREATED);

    }

    @GetMapping(value = "/{color}", produces = {"application/json"})
    Color getOneColor(@PathVariable(name = "color", required = false) Color color){
        if(color == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couleur introuvable");
        }else{
            return color;
        }
    }
}
