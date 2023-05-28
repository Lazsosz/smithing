package hu.peterlazsan.smith.model.dao;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "smith")
@NamedQuery(name = "Smith.findAll", query = "SELECT s FROM Smith s")
@Data
public class Smith {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;
}
