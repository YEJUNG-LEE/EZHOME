package EZHome.repository;

import EZHome.entity.SeCe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeCeRepository extends JpaRepository<SeCe, Long> {
    SeCe findEmailByMember_Id(Long id);
}
