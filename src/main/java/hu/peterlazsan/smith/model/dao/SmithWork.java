package hu.peterlazsan.smith.model.dao;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "smith_work")
@NamedQuery(name = "SmithWork.findAll", query = "SELECT s FROM SmithWork s")
@Data
public class SmithWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "smith_id")
    private Long smithId;

    @Column(name = "work")
    private Long work;
}
