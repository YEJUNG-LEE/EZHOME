package EZHome.dto;


import EZHome.entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@ToString
public class MemberFormDto {

    private Long id;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    private String email ;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 대, 소문자, 숫자, 특수문자를 이용하세요.")
    private String membPassword ;

    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    private String membNick ;

    @NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String membName ;

    @Pattern(regexp = "^\\d{6}$")
    @NotEmpty(message = "생년월일은 필수 입력 값입니다.")
    private String membBirth ;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String membAddress1 ;

    private String membAddress2 ;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "잘못된 전화번호 형식입니다.")
    @NotEmpty(message = "전화번호는 필수 입력 값입니다. ex)010-0000-0000")
    private String membPhone ;

    @NotEmpty(message = "구분을 선택해주세요.")
    private String role;

    private static ModelMapper modelMapper = new ModelMapper() ;

    public static MemberFormDto of(Member member) {
        return modelMapper.map(member, MemberFormDto.class);
    }
}