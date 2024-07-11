package showroom.web.rest.dto;

import lombok.Data;
import showroom.model.Manufacturer;

@Data
public class CarDTO {
    private String name;
    private String carImage;
    private int manufacturerId;
    private int year;
    private int price;
}
