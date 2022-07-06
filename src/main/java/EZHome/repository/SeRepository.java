package EZHome.repository;

import EZHome.entity.SeCe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SeRepository extends JpaRepository<SeCe, Long>,
        QuerydslPredicateExecutor<SeCe> {
}
