package showroom.web.rest;

import org.springframework.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import showroom.model.Showroom;
import showroom.service.ShowroomService;

@Component
@RequiredArgsConstructor
public class ShowroomValidator implements Validator {

    private final ShowroomService showroomService;

    @Override
    public boolean supports(Class<?> clazz) { return clazz.isAssignableFrom(Showroom.class); }

    @Override
    public void validate(Object target, Errors errors) {
        Showroom validatedShowroom = (Showroom) target;

        boolean duplicated = showroomService.getAllShowrooms().stream()
                .anyMatch(showroom -> showroom.getName().equalsIgnoreCase(validatedShowroom.getName()));

        if (duplicated) {
            errors.rejectValue("name", "showroom.name.duplicated", "Showroom name already exists");
        }
    }


}
