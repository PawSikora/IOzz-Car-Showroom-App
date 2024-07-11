package showroom.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.LocaleResolver;
import showroom.model.Car;
import showroom.model.Showroom;
import showroom.service.CarService;
import showroom.service.ShowroomService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class ShowroomRest {

    private final ShowroomService showroomService;
    private final CarService carService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final ShowroomValidator validator;

    /*@InitBinder
    void initBinder(WebDataBinder binder) { binder.addValidators(validator); }*/

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
    ResponseEntity<?> addShowroom(@Validated @RequestBody Showroom showroom, Errors errors, HttpServletRequest request) {
        log.info("about to add new showroom: {}", showroom);

        if(errors.hasErrors()) {
            /*String errorMessage = errors.getAllErrors().stream()
                    .map(oe->oe.toString())
                    .reduce("errors:\n", (accu, oe)->accu + oe + "\n");*/
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe)->accu + oe + "\n");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

        showroom = showroomService.addShowroom(showroom);
        log.info("new showroom added {}", showroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(showroom);
    }
}
