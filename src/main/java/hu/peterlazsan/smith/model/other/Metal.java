package hu.peterlazsan.smith.model.other;

import jakarta.persistence.*;
import lombok.Data;


@Data
public class Metal {

    private long id;

    private String name;

    private int price;

    private int weight;

    private int durability;

    private int hardness;

    private int sharpness;

    private int toughness;

    private int heatResistance;

    private int corrosionResistance;

    private int electricalConductivity;
}
