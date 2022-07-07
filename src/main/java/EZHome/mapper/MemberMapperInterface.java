package EZHome.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface MemberMapperInterface {
    @Delete(" delete from member where member_id=#{id} ")
    int Delete(@Param("id") final String id);
}
