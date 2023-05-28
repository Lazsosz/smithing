package hu.peterlazsan.smith.model.other;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Item {


    private Long id;

    private String name;

    private Integer price;

    private Metal madeFrom;

}
