package EZHome.service;

import EZHome.entity.ReImg;
import EZHome.repository.ReEsImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional
public class ReImgService {

    @Value("${itemImgLocation}")
    private String itemImgLocation; // 내가 올린 이미지가 업로드 되는 로컬 경로

    private final ReEsImgRepository reEsImgRepository;
    private FileService fileService;


    // 상품에 대한 이미지 정보를 저장해줍니다.
    public void savedItemImg(ReImg reImg, MultipartFile itemImgFile) throws Exception{

        String reOriNm = itemImgFile.getOriginalFilename() ; // 업로드 했던 이미지의 원본파일 이름
        String reImgNm =""; // uuid 형식의 저장된 이미지 이름
        String reImgUrl = "" ; // 상품 이미지 불러 오는 경로

        //StringUtils(.thymeleaf)
        if(!StringUtils.isEmpty(reOriNm)){  // 원본 파일 이름이 있으면 업로드 하기
            reImgNm = fileService.uploadFile(itemImgLocation, reOriNm, itemImgFile.getBytes());
            reImgUrl = "/images/item/" + reImgNm ;

        }
        // 상품 이미지 정보를 저장합니다.
        reImg.updateItemImg(reOriNm, reImgNm, reImgUrl);
        reEsImgRepository.save(reImg);
    }

}
