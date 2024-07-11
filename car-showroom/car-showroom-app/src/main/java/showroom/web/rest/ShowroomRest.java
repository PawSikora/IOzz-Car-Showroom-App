package showroom.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import showroom.model.Showroom;
import showroom.service.ShowroomService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ShowroomRest {

    private  final ShowroomService showroomService;

    @GetMapping("/showrooms")
    List<Showroom> getShowrooms() {
        log.info("aobut to retrieve showrooms list");
        List<Showroom> showrooms = showroomService.getAllShowrooms();
        log.info("{} showrooms found", showrooms.size());
        return showrooms;
    }
}
