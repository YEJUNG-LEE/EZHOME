package EZHome.service;

import EZHome.dto.SeCeDto;
import EZHome.entity.Member;
import EZHome.entity.SeCe;
import EZHome.repository.MemberRepository;
import EZHome.repository.SeCeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SeService {
    private final SeCeRepository seCeRepository;
    private final MemberRepository memberRepository;

    public void savedSeCe(SeCeDto seCeDto, Member member){

        System.out.println("********************************");
        System.out.println("*********고객센터 서비스 들어왔습니다.*******");
        System.out.println("********************************");

        SeCe seCe = seCeRepository.findEmailByMember_Id(member.getId());

        System.out.println("********************************");
        System.out.println("*********작성한 사람의 아이디를 가져왔습니다.******");
        System.out.println("seCe : " + seCe);

        seCe = seCeDto.createSeCe();
        System.out.println("********************************");
        System.out.println("*********dto -> entity 했슴니당******");

        member = memberRepository.findByEmail(member.getEmail());
        System.out.println("********************************");
        System.out.println("*********사용자의 이메일을 찾았씁니다..******");
        System.out.println("member : " + member);

        seCe.setMember(member);
        System.out.println("********************************");
        System.out.println("*********사용자의 정보를 문의사항 entity에 set했습니다. *****");

        seCeRepository.save(seCe);
        System.out.println("*********완료*****");




    }
}
