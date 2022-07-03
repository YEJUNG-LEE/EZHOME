package EZHome.service;

import EZHome.dto.ReMncsDto;
import EZHome.entity.MapFilter;
import EZHome.entity.Member;
import EZHome.repository.ConditionRepository;
import EZHome.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
@Transactional
@RequiredArgsConstructor
public class ConditionService {

    private final ConditionRepository conditionRepository;
    private final MemberRepository memberRepository;


    // 조건 저장
    public Long saveCondi(ReMncsDto reMncsDto, Model model, String email){

        System.out.println("********************************");
        System.out.println("*********서비스 들어왔습니다.*******");
        System.out.println("********************************");

        MapFilter mapFilter = reMncsDto.createReEs();
        Member member = memberRepository.findByEmail(email);
        mapFilter.setMember(member);
        conditionRepository.save(mapFilter);

        return mapFilter.getId();
    }

}
