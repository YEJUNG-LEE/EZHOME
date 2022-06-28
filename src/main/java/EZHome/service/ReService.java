package EZHome.service;

import EZHome.dto.ReFormDto;
import EZHome.dto.ReImgDto;
import EZHome.entity.ReEs;
import EZHome.entity.ReImg;
import EZHome.repository.ReEsImgRepository;
import EZHome.repository.ReEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
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

        return reEs.getId();
    }

    private final ReEsImgRepository reEsImgRepository;

    public ReFormDto getItemDtl(Long id){
        List<ReImg> itemImgList = reEsImgRepository.findByIdOrderByIdAsc(id);

        // 3. dto를 저장시킬 리스트 컬렉션 생성 ( dto -> Jpa 연동)
        List<ReImgDto> reImgDtoList = new ArrayList<ReImgDto>();

        // 수정페이지는 기존 등록정보가 화면에 띄어져야 하므로
        // 반복문을 사용하여 entity를 dto로 변경시켜 컬렉션에 답습니다.

        for(ReImg reImg: itemImgList){
            // 타입이 다름으로 of()메소드를 이용해 itemImg(entity)-> dto 타입으로 변경
            ReImgDto reImgDto = ReImgDto.of(reImg);

            // 수정이므로 비어있는 화면이미지 lIST 컬렉션에, 기존에 담겨 있던 등록이미지를 넣어 표현합니다.
            reImgDtoList.add(reImgDto);
        }

        //4. 상품 entity 정보를 구합니다.
        ReEs reEs = reEsRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        //5. of() 메소드를 사용해서 id로 조회한 등록된 item entity 정보들을 dto로 변경 ->
        // 이유 : 화면에 넣기 위해서
        ReFormDto reFormDto = ReFormDto.of(reEs);

        // 6 setItemImgDtoList() :
        //상품 등록시 첨부할 상품 이미지 정보들을
        // 저장할 리스트 컬렉션으로 화면에 기재가 됨(최대 5개 이미지)
        reFormDto.setReImgDtoList(reImgDtoList);

        return reFormDto;
    }



}