package EZHome.repository;

import EZHome.entity.ContentImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentImgRepository extends JpaRepository<ContentImg, Long> {
//    List<ContentImg> findByContentIdOrderByIdAsc(Long content_Id);
}
