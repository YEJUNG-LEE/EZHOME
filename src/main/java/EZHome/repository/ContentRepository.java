package EZHome.repository;

import EZHome.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
//    List<Content> findByContentName(String contentName);
}
