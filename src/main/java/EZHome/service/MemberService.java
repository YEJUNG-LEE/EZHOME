package EZHome.service;

import EZHome.dto.MemberFormDto;
import EZHome.entity.Member;
import EZHome.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

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

    public MemberFormDto updateMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        MemberFormDto memberFormDto = MemberFormDto.of(member) ;

        member.updateMember(memberFormDto);

        return memberFormDto;
    }
}
