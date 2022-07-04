package EZHome.repository;

import EZHome.entity.ReEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReRepositoryCustom {
    Page<ReEs> getAdminReEsPage(Pageable pageable);
}
