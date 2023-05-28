package hu.peterlazsan.smith.model.repos;

import hu.peterlazsan.smith.model.dao.Smith;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmithRepo extends JpaRepository<Smith, Long> {
}
