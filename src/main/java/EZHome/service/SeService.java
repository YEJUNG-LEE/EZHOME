package EZHome.service;

import EZHome.dto.SeFormDto;
import EZHome.entity.Member;
import EZHome.entity.SeCe;
import EZHome.entity.SeImg;
import EZHome.repository.MemberRepository;
import EZHome.repository.SeImgRepository;
import EZHome.repository.SeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SeService {
    private final SeRepository seRepository;

    private final SeImgService seImgService;
    private final MemberRepository memberRepository;

    public Long savedSeCe(SeFormDto seFormDto, List<MultipartFile> inquiryImgFileList, String email) throws Exception {
        SeCe seCe = seFormDto.createSeCe();
        Member member = memberRepository.findByEmail(email);
        seCe.setMember(member);
        System.out.println("createSeCe 오류 안남");

        seRepository.save(seCe);

        for(int i = 1; i < inquiryImgFileList.size(); i++){
            SeImg seImg = new SeImg();

            seImg.setSeCe(seCe);
            seImgService.savedServiceImg(seImg, inquiryImgFileList.get(i));
        }
        return seCe.getId();
    }
}
