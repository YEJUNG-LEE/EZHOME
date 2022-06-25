package EZHome.service;

import EZHome.entity.ContentImg;
import EZHome.repository.ContentImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class  ContentImgService {
    @Value("${contentImgLocation}")
    private String contentImgLocation;

    private final ContentImgRepository contentImgRepository;
    private final FileService fileService;

    private String savedImagePath = "/images/content/";

    public void saveContentImg(ContentImg contentImg, MultipartFile contentImgFile) throws Exception{
        String oriImgName = contentImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        if(!StringUtils.isEmpty(oriImgName)){
            imgName = fileService.uploadFile(contentImgLocation, oriImgName, contentImgFile.getBytes());
            imgUrl = savedImagePath + imgName;
        }
        contentImg.updateContentImg(oriImgName, imgName, imgUrl);

        contentImgRepository.save(contentImg);
    }

    public void updateContentImg(Long contentImgId, MultipartFile contentImgFile) throws Exception{
        if(!contentImgFile.isEmpty()){
            ContentImg savedContentImg = contentImgRepository.findById(contentImgId)
                    .orElseThrow(EntityNotFoundException::new);

            if(!StringUtils.isEmpty(savedContentImg.getImgName())){
                fileService.deleteFile(contentImgLocation + "/" + savedContentImg.getImgName());
            }

            String oriImgName = contentImgFile.getOriginalFilename();

            String imgName = fileService.uploadFile(contentImgLocation, oriImgName, contentImgFile.getBytes());
            String imgUrl = savedImagePath + imgName;
            savedContentImg.updateContentImg(oriImgName, imgName, imgUrl);
        }
    }
}
