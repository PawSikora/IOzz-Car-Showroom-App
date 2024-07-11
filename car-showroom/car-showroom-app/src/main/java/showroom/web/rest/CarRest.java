package showroom.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import showroom.model.Car;
import showroom.model.Showroom;
import showroom.service.CarService;
import showroom.service.ShowroomService;
import showroom.web.rest.dto.CarDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class CarRest {

    private final ShowroomService showroomService;
    private final CarService carService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;


    @GetMapping("/cars")
    List<Car> getCars(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie) {
        log.info("about to retrieve cars list");
        log.info("phrase param: {}", phrase);
        log.info("custom-header: {}", customHeader);
        log.info("some cookie value: {}", someCookie);
        List<Car> cars = carService.getAllCars();
        log.info("{} cars found", cars.size());
        return cars;
    }

    @GetMapping("/cars/{id}")
    ResponseEntity<Car> getCar(@PathVariable("id") int id) {
        log.info("about to retrieve car with id {}", id);
        Car car = carService.getCarById(id);
        log.info("car found: {}", car);
        if(car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("showrooms/{showroomId}/cars")
    ResponseEntity<List<Car>> getCarsInShowroom(@PathVariable("showroomId") int showroomId) {
        log.info("about to retrieve cars in showroom with id {}", showroomId);
        Showroom showroom = showroomService.getShowroomById(showroomId);
        if(showroom == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<Car> cars = showroomService.getCarsInShowroom(showroom);
            log.info("there's {} cars found in showroom {}", cars.size(), showroom.getName());
            return ResponseEntity.ok(cars);
        }
    }

    @PostMapping("/cars")
    ResponseEntity<?> addCar(@RequestBody CarDTO carDTO) {
        log.info("about to add a new car");
        Car car = new Car();
        car.setName(carDTO.getName());
        car.setCarImage(carDTO.getCarImage());
        car.setYear(carDTO.getYear());
        car.setPrice(carDTO.getPrice());
        car.setManufacturer(carService.getManufacturerById(carDTO.getManufacturerId()));

        carService.addCar(car);
        log.info("new car added: {}", car);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + car.getId())
                                .build()
                                .toUri())
                .body(car);
    }
}
