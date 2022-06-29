package EZHome.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Log // 콘솔창에 띄우는 기능
public class FileService {
    // 이미지 업로드합니다.
    public String uploadFile(String uploadPath, String originalFileName, byte[]fileData) throws Exception{ // 예외처리(try.catch 대신)
        //String uploadPath(내가 올린 이미지가 상품 이미지가 업로드 되는 로컬 경로), String originalFileName(파일이름 원본), byte[]fileData : 업로드할 데이터 (이미지를 올리는건 byte 파일을 올리는것)

        // 파일의 의미있는 이름이 다음과 같이(숫자하이포섞여 다시) 교유한 이름으로 만드는 것
        UUID uuid = UUID.randomUUID();
        String extention = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자 .jpg. png

        String savedFileName =uuid.toString() + extention ; // 저장될 파일 이름
        String fileUploadFullUrl = uploadPath + "/" + savedFileName ; // 전체 경로 포함

        // "파일 경로"를 사용하여 "바이트 출력 스트림"을 만들어 주는 클래스
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
        fos.write(fileData); // 네트워크를 통한 파일 쓰기 (업로드)
        fos.close();

        return savedFileName;
    }
    // 특정 상품 이미지에 대한 수정 작업시 이전 이미지에 대한 삭제를 합니다.
    public void deleteFile(String filepath) throws Exception{

        //filepath는 삭제될 파일의 경로 및 이름 정보를 담고 있는 변수
        File deleteFile = new File(filepath); // File(java.i0) // 삭제될파일 객체

        if(deleteFile.exists()){ // 파일 존재한다면
            deleteFile.delete();
            log.info("파일을 삭제하였습니다.");
        }else{ // 존재하지 않다면
            log.info("해당 파일이 존재하지 않습니다.");
        }

    }

}
