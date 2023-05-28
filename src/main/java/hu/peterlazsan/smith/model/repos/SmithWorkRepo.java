package hu.peterlazsan.smith.model.repos;

import hu.peterlazsan.smith.model.dao.SmithWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmithWorkRepo extends JpaRepository<SmithWork, Long> {
}
