package EZHome.service;

import EZHome.entity.SeImg;
import EZHome.repository.SeImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class SeImgService {
    @Value("${serviceImgLocation}")
    private String serviceImgLocation;

    private final SeImgRepository seImgRepository;
    private final FileService fileService;

    public void savedServiceImg(SeImg seImg, MultipartFile serviceImgFile) throws Exception {
        String seOriNm = serviceImgFile.getOriginalFilename();
        String seImgNm = "";
        String seImgUrl = "";

        if(!StringUtils.isEmpty(seOriNm)){
            seImgNm = fileService.uploadFile(serviceImgLocation, seOriNm, serviceImgFile.getBytes());
            seImgUrl = "/images/service" + seImgNm;
        }
        seImg.updateServiceImg(seOriNm, seImgNm, seImgUrl);
        seImgRepository.save(seImg);
    }
}
