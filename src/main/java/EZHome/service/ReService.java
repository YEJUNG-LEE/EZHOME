package EZHome.service;

import EZHome.dto.ReFormDto;
import EZHome.entity.ReEs;
import EZHome.entity.ReImg;
import EZHome.repository.ReEsImgRepository;
import EZHome.repository.ReEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReService {


    private final ReEsRepository reEsRepository;
    private final ReImgService reImgService;
    //상품 등록 폼에서 입력 받은 데이터(Dto)를 이용하여  상품 데이터(entity)를 저장시키고,
    // 반 복문을 사용하여 상품에 따른 이미지들을 저장합니다.
    public Long savedReEs(ReFormDto reFormDto, List<MultipartFile> itemImgFileList) throws Exception {

        // 1. 상품등록 ( createReEs() : Dto -> Entity )
        ReEs reEs = reFormDto.createReEs();
        reEsRepository.save(reEs); // 매물 상품 데이터 저장
        /*종욱*/
        // 매물 커스텀 데이터 저장
        // 매물 카테고리 데이터 저장

        // 2. 상품 이미지 등록
        // 반복문으로 해당 상품(ReEs)과 관련된 이미지(ReImg)들 저장하기
        for (int i = 0; i < itemImgFileList.size(); i++) {
            ReImg reImg = new ReImg();

            reImg.setReEs(reEs);
            if(i == 0 ){
                reImg.setReYN("Y"); //대표이미지
            }else{
                reImg.setReYN("N"); //나머지 이미지
            }

            // 상품의 이미지 정보를 저장합니다.
            reImgService.savedItemImg(reImg, itemImgFileList.get(i));

        } // end for다 ~

        return reEs.getReid();
    }
}
