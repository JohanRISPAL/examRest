package com.humanbooster.examRest;

import com.humanbooster.examRest.model.Car;
import com.humanbooster.examRest.model.Color;
import com.humanbooster.examRest.repositories.CarRepository;
import com.humanbooster.examRest.repositories.ColorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
public class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(CarRepository carRepository, ColorRepository colorRepository) throws ParseException {
        if(carRepository.count() == 0 && colorRepository.count() == 0){
            Car car = new Car("Porshe", "Cayenne", "500", 2010, 150000, 2000000, "Ceci est une magnifique voiture");
            Car car1 = new Car("Lamborghini", "Aventador", "600", 2015, 569845, 500000, "Wow c'est de la balle");
            Car car2 = new Car("Renault", "Clio", "40", 2003, 0, 2500, "Super pour une première voiture !");
            Car car3 = new Car("Peugeot", "206", "60", 2002, 25698, 3000, "La voiture du diable");

            Color color = new Color("#FF0000", "Rouge");
            Color color1 = new Color("#0000FF", "Bleu");
            Color color2 = new Color("#FFFF00", "Jaune");
            Color color3 = new Color("#800080", "Violet");

            return args -> {
                log.info("Preloading " + carRepository.save(car));
                log.info("Preloading " + carRepository.save(car1));
                log.info("Preloading " + carRepository.save(car2));
                log.info("Preloading " + carRepository.save(car3));

                log.info("Preloading " + colorRepository.save(color));
                log.info("Preloading " + colorRepository.save(color1));
                log.info("Preloading " + colorRepository.save(color2));
                log.info("Preloading " + colorRepository.save(color3));
            };
        }else{
            return args -> {
                log.info("Voitures déjà implémentées");
            };
        }
    }
}
