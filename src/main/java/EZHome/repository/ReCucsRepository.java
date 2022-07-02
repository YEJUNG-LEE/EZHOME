package EZHome.repository;

import EZHome.entity.ReCucs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReCucsRepository extends JpaRepository<ReCucs, Long>{

    ReCucs findByReEs_Id(Long id);
}
