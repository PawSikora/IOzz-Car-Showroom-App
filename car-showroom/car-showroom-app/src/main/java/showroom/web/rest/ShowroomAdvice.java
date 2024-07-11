package showroom.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class ShowroomAdvice {

    private final ShowroomValidator validator;

    @InitBinder
    void initBinder(WebDataBinder binder) { binder.addValidators(validator); }

}
