package EZHome.repository;

import EZHome.entity.ReEs;
import EZHome.entity.ReImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ReEsRepository extends JpaRepository<ReEs, Long>,
        QuerydslPredicateExecutor<ReEs>, ReEsRepositoryCustom {

    List<ReEs>findByReNum(Integer reNum);


}
