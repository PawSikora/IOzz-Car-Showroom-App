package showroom.service;

import showroom.model.Showroom;
import showroom.repository.CarDao;
import showroom.repository.ShowroomDao;
import showroom.repository.mem.MemCarDao;
import showroom.repository.mem.MemShowroomDao;
import showroom.service.impl.ShowroomServiceBean;

import java.util.List;

public class ShowroomServiceMain {
    public static void main(String[] args) {
        System.out.println("Let's find showrooms!");

        ShowroomDao showroomDao = new MemShowroomDao();
        CarDao carDao = new MemCarDao();

        ShowroomService service = new ShowroomServiceBean(showroomDao, carDao);

        List<Showroom> showrooms = service.getAllShowrooms();
        System.out.println(showrooms.size() + " showrooms found:");
        showrooms.forEach(System.out::println);
    }
}
