package showroom.repository.mem;

import showroom.model.Car;
import showroom.model.Manufacturer;
import showroom.model.Showroom;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    static List<Car> cars = new ArrayList<>();

    static List<Manufacturer> manufacturers = new ArrayList<>();

    static List<Showroom> showrooms = new ArrayList<>();

    static {

        Manufacturer ford = new Manufacturer(1, "Ford", "USA");
        Manufacturer fiat = new Manufacturer(2, "Fiat", "Italy");
        Manufacturer audi = new Manufacturer(3, "Audi", "Germany");

        Car focus = new Car(1, "Focus", "https://cars.usnews.com/static/images/Auto/izmo/i51570132/2018_ford_focus_angularfront.jpg", ford, 2018, 50000);
        Car fiesta = new Car(2, "Fiesta", "https://www.motortrend.com/uploads/sites/10/2018/10/2019-ford-fiesta-s-sedan-angular-front.png", ford, 2019, 40000);
        Car mustang = new Car(3, "Mustang", "https://www.motortrend.com/uploads/sites/10/2016/06/2017-ford-mustang-v6-coupe-angular-front.png", ford, 2017, 100000);

        Car punto = new Car(4, "Punto", "https://imgd.aeplcdn.com/1280x720/cw/ec/21942/Fiat-Punto-Pure-Right-Front-Three-Quarter-66366.jpg?wm=0&q=80", fiat, 2016, 30000);
        Car tipo = new Car(5, "Tipo", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Fiat_Tipo_%282017%29_in_Hasselt.jpg/1200px-Fiat_Tipo_%282017%29_in_Hasselt.jpg", fiat, 2017, 35000);
        Car panda = new Car(6, "Panda", "https://limobelgrade.rs/wp-content/uploads/2021/03/fiat_panda_1-1.jpg", fiat, 2018, 32000);

        Car a3 = new Car(7, "A3", "https://images.hgmsites.net/lrg/2019-audi-a3-sedan-premium-40-tfsi-angular-front-exterior-view_100694917_l.jpg.jpg", audi, 2019, 70000);
        Car a4 = new Car(8, "A4", "https://cars.usnews.com/pics/size/390x290/images/Auto/izmo/i62379705/2018_audi_a4_angularfront.jpg", audi, 2018, 80000);
        Car a6 = new Car(9, "A6", "https://cdn.wheel-size.com/automobile/body/audi-a6-2014-2018-1683446803.5132124.jpg", audi, 2017, 90000);

        bind(focus, ford);
        bind(fiesta, ford);
        bind(mustang, ford);

        bind(punto, fiat);
        bind(tipo, fiat);
        bind(panda, fiat);

        bind(a3, audi);
        bind(a4, audi);
        bind(a6, audi);

        Showroom salonFord = new Showroom(1, "Salon Ford", "https://upload.wikimedia.org/wikipedia/commons/d/d8/Ford_logo.svg");
        Showroom salonFiat = new Showroom(2, "Salon Fiat", "https://stellantis3.dam-broadcast.com/medias/domain12808/media102550/765271-8dyab6fsa1-whr.jpg");
        Showroom salonAudi = new Showroom(3, "Salon Audi", "https://www.shutterstock.com/image-vector/audi-logo-icon-metal-circle-600nw-2269704655.jpg");

        bind(salonFord, focus);
        bind(salonFord, fiesta);
        bind(salonFord, mustang);

        bind(salonFiat, punto);
        bind(salonFiat, tipo);
        bind(salonFiat, panda);

        bind(salonAudi, a3);
        bind(salonAudi, a4);
        bind(salonAudi, a6);

        manufacturers.add(ford);
        manufacturers.add(fiat);
        manufacturers.add(audi);

        showrooms.add(salonFord);
        showrooms.add(salonFiat);
        showrooms.add(salonAudi);

        cars.add(focus);
        cars.add(fiesta);
        cars.add(mustang);

        cars.add(punto);
        cars.add(tipo);
        cars.add(panda);

        cars.add(a3);
        cars.add(a4);
        cars.add(a6);
    }

    private static void bind(Showroom s, Car c) {
        s.addCar(c);
        c.addShowroom(s);
    }

    private static void bind(Car c, Manufacturer m) {
        c.setManufacturer(m);
        m.addCar(c);
    }


}
