package EZHome.service;

import EZHome.dto.MapMainDto;
import EZHome.dto.MemberFormDto;
import EZHome.entity.Member;
import EZHome.mapper.MemberMapperInterface;
import EZHome.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder ;

    public Member saveMember(Member member){
        validateDuplicateMember(member);

        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());

        if (findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String Memb_email)
        throws UsernameNotFoundException {
            Member member = memberRepository.findByEmail(Memb_email) ;
            if(member == null){ // 회원이 존재하지 않는 경우
                throw new UsernameNotFoundException(member.getEmail()) ;
            }
            return User.builder()
                    .username(member.getEmail())
                    .password(member.getMembPassword())
                    .roles(member.getRole().toString())
                    .build();
    }
    public String userInfo(String email){
        String info = "" ;
        info = memberRepository.findByEmail(email).getMembName() ;

        return info ;
    }

    @Transactional(readOnly = true)
    public MemberFormDto getName(String email) {
        System.out.println(email);
        Member member = memberRepository.findByEmail(email);
        System.out.println(member.toString());
        MemberFormDto memberFormDto = MemberFormDto.of(member) ;

        return memberFormDto ;
    }

    @Transactional(readOnly = true)
    public MemberFormDto getAddress(String membAddress1){
        System.out.println(membAddress1);
        Member address = memberRepository.findByMembAddress1(membAddress1);
        System.out.println(address);
        MemberFormDto memberFormDto = MemberFormDto.of(address);

        return memberFormDto;
    }

    public MemberFormDto updateMember(Long id, MemberFormDto memberFormDto){
        Member member = memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        member.updateMember(memberFormDto, passwordEncoder);
        memberRepository.save(member);
        return memberFormDto;
    }

    private final MemberMapperInterface memberMapperInterface;
    public int Delete(String id){
        return memberMapperInterface.Delete(id);
    }

    // 여기서 부터 내가 함
    @Transactional(readOnly = true)
    public MapMainDto getMemAddress(String membAddress1){
        Member memberaddress = memberRepository.findByMembAddress1(membAddress1);
        MapMainDto mapMainDto = MapMainDto.memof(memberaddress);

        return mapMainDto;
    }


}
