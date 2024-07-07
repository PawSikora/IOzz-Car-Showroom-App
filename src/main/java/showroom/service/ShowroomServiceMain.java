package showroom.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import showroom.model.Showroom;
import showroom.repository.CarDao;
import showroom.repository.ShowroomDao;
import showroom.repository.mem.MemCarDao;
import showroom.repository.mem.MemShowroomDao;
import showroom.service.impl.ShowroomServiceBean;

import java.util.List;

public class ShowroomServiceMain {
    public static void main(String[] args) {
       /*
        ShowroomDao showroomDao = new MemShowroomDao();
        CarDao carDao = new MemCarDao();
        */

        System.out.println("Let's find showrooms!");

        ApplicationContext context = new AnnotationConfigApplicationContext("showroom");
        ShowroomService service = context.getBean(ShowroomServiceBean.class);
        ShowroomService service2 = context.getBean(ShowroomService.class);

        List<Showroom> showrooms = service.getAllShowrooms();
        System.out.println(showrooms.size() + " showrooms found:");
        showrooms.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}
