package showroom.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import showroom.model.Car;
import showroom.model.Showroom;
import showroom.service.CarService;
import showroom.service.ShowroomService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class ShowroomRest {

    private  final ShowroomService showroomService;
    private final CarService carService;

    @GetMapping("/showrooms")
    List<Showroom> getShowrooms(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie ) {
        log.info("about to retrieve showrooms list");
        log.info("phrase param: {}", phrase);
        log.info("custom-header: {}", customHeader);
        log.info("some cookie value: {}", someCookie);
        List<Showroom> showrooms = showroomService.getAllShowrooms();
        log.info("{} showrooms found", showrooms.size());
        return showrooms;
    }

    @GetMapping("/showrooms/{id}")
    ResponseEntity<Showroom> getShowroom(@PathVariable("id") int id) {
        log.info("about to retrieve showroom with id {}", id);
        Showroom showroom = showroomService.getShowroomById(id);
        log.info("showroom found: {}", showroom);
        if(showroom != null) {
            return ResponseEntity.ok(showroom);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cars/{carId}/showrooms")
    ResponseEntity<List<Showroom>> getShowroomsByCar(@PathVariable("carId") int carId) {
        log.info("about to retrieve showrooms with a car {}", carId);
        Car car = carService.getCarById(carId);
        if(car == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<Showroom> showrooms = showroomService.getShowroomsByCar(car);
            log.info("{} showrooms found for car {}", showrooms.size(), car.getName());
            return ResponseEntity.ok(showrooms);
        }
    }

    @PostMapping("/showrooms")
    ResponseEntity<Showroom> addShowroom(@RequestBody Showroom showroom) {
        log.info("about to add new showroom: {}", showroom);
        showroom = showroomService.addShowroom(showroom);
        log.info("new showroom added {}", showroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(showroom);
    }
}
