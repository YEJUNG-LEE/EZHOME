package EZHome.dto;

import EZHome.constant.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberDto {
    private Long id ;
    private String Memb_name;
    private String Memb_nick;

}
