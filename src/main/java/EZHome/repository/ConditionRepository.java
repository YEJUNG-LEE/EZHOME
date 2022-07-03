package EZHome.repository;

import EZHome.entity.MapFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConditionRepository extends JpaRepository<MapFilter, Long> {

}
