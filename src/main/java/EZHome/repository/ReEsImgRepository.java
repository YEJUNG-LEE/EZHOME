package EZHome.repository;

import EZHome.entity.ReImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReEsImgRepository extends JpaRepository<ReImg, Long> {

    // 상품의 id를 이용해, 상품에 대한 이미지들의 id를 오름차순으로 정렬하는 쿼리
    List<ReImg> findByIdOrderByIdAsc(Long id);

    List<ReImg> findByReEs_IdOrderByIdAsc(Long id);


    // 상품 아이디를 이용하여 특정 상품에 대한 대표 이미지를 조회합니다.
    // repimgYn 매개변수에 "Y" 가 입력되어야 합니다.
//    ReImg findByReIdAndReYN(Long reid, String reYN);
}