package com.humanbooster.examRest.repositories;

import com.humanbooster.examRest.model.Color;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColorRepository extends CrudRepository<Color, Long> {

    @Override
    List<Color> findAll();
}
