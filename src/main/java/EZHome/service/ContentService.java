package EZHome.service;

import EZHome.dto.ContentFormDto;
import EZHome.dto.ContentImgDto;
import EZHome.entity.Content;
import EZHome.entity.ContentImg;
import EZHome.repository.ContentImgRepository;
import EZHome.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;
    private final ContentImgService contentImgService;

    public Long saveContent(ContentFormDto contentFormDto, List<MultipartFile> contentImgFileList) throws Exception {
        Content content = contentFormDto.createContent();
        contentRepository.save(content);

        for(int i = 0; i < contentImgFileList.size(); i++){
            ContentImg contentImg = new ContentImg();

            contentImg.setContent(content);

            if(i == 0){
                contentImg.setRepImgYn("Y");
            }else{
                contentImg.setRepImgYn("N");
            }

            contentImgService.saveContentImg(contentImg, contentImgFileList.get(i));
        }
        return content.getId();
    }

    private final ContentImgRepository contentImgRepository;

//    @Transactional(readOnly = true)
//    public ContentFormDto getContentDtl(Long content_id){
//        List<ContentImg> contentImgList = contentImgRepository.findByContentIdOrderByIdAsc(content_id);
//        List<ContentImgDto> contentImgDtoList = new ArrayList<ContentImgDto>();
//
//        for(ContentImg contentImg : contentImgList){
//            ContentImgDto contentImgDto = ContentImgDto.of(contentImg);
//            contentImgDtoList.add(contentImgDto);
//        }
//        Content content = contentRepository.findById(content_id)
//                .orElseThrow(EntityNotFoundException::new);
//        ContentFormDto contentFormDto = ContentFormDto.of(content);
//        contentFormDto.setContentImgDtoList(contentImgDtoList);
//
//        return contentFormDto;
//    }
}
