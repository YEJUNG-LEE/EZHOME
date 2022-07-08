package EZHome.repository;

import EZHome.dto.MapMainDto;
import EZHome.dto.MapSearchDto;
import EZHome.entity.*;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class ReEsRepositoryCustomImpl implements ReEsRepositoryCustom{

//    private JPAQueryFactory queryFactory;

//    public ReEsRepositoryCustomImpl(EntityManager em){
//        this.queryFactory = new JPAQueryFactory(em);
//    }
//


//    // 상품 이름으로 매물을 검색하는 메소드 (in map)
//    @Override
//    public Page<MapMainDto> getMainItemPage(MapSearchDto mapSearchDto, Pageable pageable) {
//        QReEs reEs = QReEs.reEs;
//        QReImg reImg = QReImg.reImg;
//
//        QueryResults<MapMainDto> results = queryFactory
//                .select(
//                        new QMapMainDto(
//                                reEs.id,
//                                reEs.retrType,
//                                reEs.reDeposit,
//                                reEs.reMon_price,
//                                reEs.reAdmn_fee,
//                                reEs.reFlr,
//                                reEs.reExtent,
//                                reEs.reSido,
//                                reEs.reGungu,
//                                reEs.reDong,
//                                reEs.reDtl_Adr,
//                                reImg.reImgUrl)
//                )
//                .from(reImg)
//                .join(reImg.reEs, reEs)
////                .join(reEs.member, mem )
//                .where(reImg.reYN.eq("Y"))
//                .where(itemNmLike(mapSearchDto.getSearchQuery()))
//
//
//                .orderBy(reEs.id.desc())
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetchResults();
//
//        List<MapMainDto> content = results.getResults();
//        long total = results.getTotal();
//
//        return new PageImpl<>(content, pageable, total);
//    }
//
//
//    // 상품 이름으로 매물을 검색하는 메소드 (in map)
//    private BooleanExpression itemNmLike(String searchQuery){
//        return StringUtils.isEmpty(searchQuery) ? null : QReEs.reEs.reNm.like("%" + searchQuery + "%");
//    }
//
//    // 관리자 상품 목록 페이지를만들시, 관리자가 상품이름으로 매물을 검색하는 메소드
//    private Predicate searchByLike(String searchBy, String searchQuery) {
//        // 상품이름, 등록자 아이디로 내용을 검색
//        if(StringUtils.equals("itemNm", searchBy)){ //상품이름이 같다면
//            return QReEs.reEs.reNm.like("%"+searchQuery+"%"); // 상품명이름과 같은 데이터들을 조회
//        }
//        return null; // 이거 왜 null 값인지 답변 바람 - 답변 :
//
//    }
//

//        @Override
//        public Page<ReEs> getAdminReEsPage(Pageable pageable) {
//            QueryResults<ReEs> results = this.queryFactory
//                    .selectFrom(QReEs.reEs)
//                    .orderBy(QReEs.reEs.id.desc())
//                    .offset(pageable.getOffset())
//                    .limit(pageable.getPageSize())
//                    .fetchResults();
//
//            List<ReEs> content = results.getResults();
//            long total = results.getTotal();
//
//            return new PageImpl<>(content, pageable, total);
//        }
}
