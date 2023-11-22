package com.example.rentcar.car;


import com.example.rentcar.car.entity.Car;
import com.example.rentcar.car.entity.Model;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.time.LocalDate;
import java.util.ArrayList;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/car")
public class CarController {

    static List<Car> cars = new ArrayList<>();


    @PostConstruct
    public void zaxa() {
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletDamas, 350, " максимальная скорость - 105 км/ч, разгон до 100 км/ч - 41 секунда.", "в городском цикле - 8,6 л, при смешанном цикле - 7,8 л. Объем бака составляет 37 литров. Рекомендуемый к использованию бензин - АИ-91.", "рядный трехцилиндровый объемом 796 куб.см. Максимальная мощность - 38 л.с.", "пятиступенчатая механическая коробка передач с задним приводом.", "снаряженная - 850 кг, максимально разрешенная - 1360 кг.",
                false, "https://avtoremont.uz/thumb/2/VU2bkX2QHAHL0vzR_ZSmqg/r/d/gm_uzbekistan_damas.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletSpark, 400, "", "", "", "", "", false, "https://avtoremont.uz/thumb/2/sqrb4FqgDSAOPGRpMzfotg/r/d/gm_uzbekistan_spark.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletCobalt, 450, "", "", "", "", "", false, "https://avtoremont.uz/thumb/2/7X6XNO7Htty9fLoDkfiOAQ/r/d/gm_uzbekistan_cobalt.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletNexia3, 500, "", "", "", "", "", false, "https://avtoremont.uz/thumb/2/woHEvOxIAxkQmROM6uUEvw/r/d/gm_uzbekistan_nexia-3.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletLacetti, 550, "", "", "", "", "", false, "https://avtoremont.uz/thumb/2/9I1aqbE2AX9hS321BcwNEg/r/d/gm_uzbekistan_lacetti.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletTracker2, 600, "", "", "", "", "", false, "https://avtoremont.uz/d/2022-chevrolet-tracker-2.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletMalibu2Turbo, 650, "", "", "", "", "", false, "https://avtoremont.uz/thumb/2/7wzOJNx02vUsy30h_q9hbQ/r/d/gm_uzbekistan_malibu.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletCaptiva, 700, "", "", "", "", "", false, "https://avtoremont.uz/thumb/2/D5-1URyVvDZ9bjNoQpm-VQ/r/d/gm_uzbekistan_captiva.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletTrailblazer, 750, "", "", "", "", "", false, "https://avtoremont.uz/d/gm-uzbekistan-trailblazer.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletEquinox2, 800, "", "", "", "", "", false, "https://avtoremont.uz/d/gm-uzbekistan-equinox.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletTraverse, 850, "", "", "", "", "", false, "https://avtoremont.uz/d/2023-chevrolet-traverse-2.jpg", LocalDate.now(), LocalDate.now()));
        cars.add(new Car(UUID.randomUUID(), Model.ChevroletTahoe, 900, "", "", "", "", "", false, "https://avtoremont.uz/d/chevrolet-tahoe-2022.jpg", LocalDate.now(), LocalDate.now()));

    }


    @GetMapping()
    public ModelAndView getAllCars(org.springframework.ui.Model model) {
        ArrayList<Car> carss = new ArrayList<>();
        for (Car car : cars) {
            if (!car.isAvailable()) {
                carss.add(car);
            }
        }

        model.addAttribute("cars", carss);
        model.addAttribute("message", "<h1 style = background-color= red>car</h1>");
        return new ModelAndView("car", "model", model);

    }


    @GetMapping({"/{id}"})
    public ModelAndView getByIdCar(@PathVariable("id") UUID id, org.springframework.ui.Model model) {

        Car getCar = cars.stream().filter(car -> car.getId().equals(id)).findFirst().get();
        model.addAttribute("getCar", getCar);
        return new ModelAndView("rent", "model", model);
    }

    @PostMapping()
    public ModelAndView getByIdCar(org.springframework.ui.Model model, @RequestParam("pickupDate") LocalDate pickupDate,
                                   @RequestParam("returnDate") LocalDate returnDate) {

        List<Car> list = cars.stream().filter(car -> car.getPickupDate().equals(pickupDate) && car.getReturnDate().equals(returnDate))
                .toList();

        model.addAttribute("arends", list);
        return new ModelAndView("rent-cars", "model", model);
    }

    @PostMapping({"/{id}"})
    public ModelAndView getByIdCar(@PathVariable("id") UUID id, org.springframework.ui.Model model
            , @RequestParam("pickupDate") LocalDate pickupDate, @RequestParam("returnDate") LocalDate returnDate) {
        Car getCar = cars.stream().filter(car -> car.getId().equals(id)).findFirst().get();
        getCar.setReturnDate(returnDate);
        getCar.setPickupDate(pickupDate);
        getCar.setAvailable(true);
        cars.add(getCar);

        model.addAttribute("getCar", getCar);
        return new ModelAndView("rent-cars", "carr", model);
    }


//    @GetMapping("/car")
//    public ModelAndView getAllCar(org.springframework.ui.Model model) {
//
//
//        model.addAttribute("cars", cars);
//        model.addAttribute("message", "<h1 style = background-color= red>car</h1>");
//        return new ModelAndView("car", "model", model);
//
//    }


}
