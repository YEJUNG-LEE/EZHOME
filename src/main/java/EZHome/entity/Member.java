package EZHome.entity;

import EZHome.constant.Role;
import EZHome.dto.MemberFormDto;
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
public class Member{
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(unique = true)
    private String email;

    private String membPassword;

    private String membNick;

    private String membName;

    private String membBirth;

    private String membAddress1;

    private String membAddress2;

    private String membPhone;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();

        member.setMembName(memberFormDto.getMembName());
        member.setEmail(memberFormDto.getEmail());
        member.setMembAddress1(memberFormDto.getMembAddress1());
        member.setMembAddress2(memberFormDto.getMembAddress2());
        member.setMembBirth(memberFormDto.getMembBirth());
        member.setMembNick(memberFormDto.getMembNick());
        member.setMembPhone(memberFormDto.getMembPhone());
        member.setRole(Role.valueOf(memberFormDto.getRole()));


        String password = passwordEncoder.encode(memberFormDto.getMembPassword());
        member.setMembPassword(password);
//        member.setRole(Role.ADMIN); // 관리자
//        member.setRole(Role.USER); // 일반사용자
//        member.setRole(Role.LREA); // 공인중개사


        return member;
    }

    public void updateMember(MemberFormDto memberFormDto) {
        this.membName = memberFormDto.getMembName();
        this.membNick = memberFormDto.getMembNick();
        this.membPassword = memberFormDto.getMembPassword();
        this.membAddress1 = memberFormDto.getMembAddress1();
        this.membAddress2 = memberFormDto.getMembAddress2();
        this.membBirth = memberFormDto.getMembBirth();
        this.membPhone = memberFormDto.getMembPhone();
    }
}
