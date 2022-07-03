package EZHome.repository;

import EZHome.entity.ReCacs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReCacsRepository extends JpaRepository <ReCacs, Long>{
    ReCacs findByReEs_Id(Long id);
}
