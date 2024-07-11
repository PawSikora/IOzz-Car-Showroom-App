package showroom;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import showroom.model.Showroom;
import showroom.service.ShowroomService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class ShowroomComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private final ShowroomService showroomService;
    public ShowroomComponent(ShowroomService showroomService) { this.showroomService = showroomService; }

   @PostConstruct
    void init() {
        List<Showroom> showrooms = showroomService.getAllShowrooms();
        log.info("{} showrooms found", showrooms.size());
        showrooms.forEach(showroom -> log.info("{}", showroom));

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Showroom> showrooms = showroomService.getAllShowrooms();
        log.info("{} showrooms found", showrooms.size());
        showrooms.forEach(showroom -> log.info("{}", showroom));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {
        log.info("on context refreshed (from annotated method)");
    }
}
