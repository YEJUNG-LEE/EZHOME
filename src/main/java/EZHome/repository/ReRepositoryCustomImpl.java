package EZHome.repository;

import EZHome.entity.QReEs;
import EZHome.entity.ReEs;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ReRepositoryCustomImpl implements ReRepositoryCustom{
    private JPAQueryFactory queryFactory;

    @Override
    public Page<ReEs> getAdminReEsPage(Pageable pageable) {
        QueryResults<ReEs> results = this.queryFactory
                .selectFrom(QReEs.reEs)
                .orderBy(QReEs.reEs.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<ReEs> content = results.getResults();
        Long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
