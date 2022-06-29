package EZHome.entity;

<<<<<<< HEAD

import EZHome.dto.MemberFormDto;
import EZHome.Role.Role;
=======
import EZHome.constant.Role;
import EZHome.dto.MemberFormDto;
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
<<<<<<< HEAD
public class Member {
=======
public class Member{
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(unique = true)
    private String email;

    private String Memb_password;

    private String Memb_nick;

    private String Memb_name;

    private String Memb_birth;

    private String Memb_address;

    private String Memb_phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();

        member.setMemb_name(memberFormDto.getMembName());
        member.setEmail(memberFormDto.getEmail());
        member.setMemb_address(memberFormDto.getMembAddress());
        member.setMemb_birth(memberFormDto.getMembBirth());
        member.setMemb_nick(memberFormDto.getMembNick());
        member.setMemb_phone(memberFormDto.getMembPhone());
        member.setRole(Role.valueOf(memberFormDto.getRole()));


        String password = passwordEncoder.encode(memberFormDto.getMembPassword());
        member.setMemb_password(password);
//        member.setRole(Role.ADMIN); // 관리자
//        member.setRole(Role.USER); // 일반사용자
//        member.setRole(Role.LREA); // 공인중개사


        return member;
    }
}
