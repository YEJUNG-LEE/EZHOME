package EZHome.repository;

import EZHome.entity.ReEs;
import EZHome.entity.ReImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ReEsRepository extends JpaRepository<ReEs, Long>,
        QuerydslPredicateExecutor<ReEs>, ReEsRepositoryCustom {


}
