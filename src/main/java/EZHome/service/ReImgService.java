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


    // 상품에 대한 이미지 정보 저장
    public void savedItemImg(ReImg reImg, MultipartFile itemImgFile) throws Exception{

        String oriImgName = itemImgFile.getOriginalFilename() ; // 업로드 했던 이미지의 원본파일 이름
        String imgName =""; // uuid 형식의 저장된 이미지 이름
        String imgUrl = "" ; // 상품 이미지 불러 오는 경로

        //StringUtils(.thymeleaf)
        if(!StringUtils.isEmpty(oriImgName)){  // 원본 파일 이름이 있으면 업로드 하기
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            imgUrl = "/images/item/" + imgName ;

        }
        // 상품 이미지 정보를 저장합니다.
        reImg.updateItemImg(oriImgName, imgName, imgUrl);

        ReEsImgRepository.save(reImg);
    }

}
