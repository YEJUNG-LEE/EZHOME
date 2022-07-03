package EZHome.dto;

import EZHome.entity.MapFilter;
import EZHome.entity.ReEs;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.OneToOne;

@Getter @Setter @ToString
public class ReMncsDto { // 기본 Dto

    // 회원 기본 조건
    private String houseType ; // 매물 유형
    private String trType; // 매매 유형
    private Integer minFloor ; // 최소 층수
    private Integer maxFloor ; // 최대 층수
    private boolean halfUnder ; // 반지하
    private boolean loofTop ; // 옥탑방
    private Integer minEx ;// 최소 평수
    private Integer maxEx ; // 최대 평수
    private Integer minMon; // 최소월세
    private Integer maxMon ; // 최대 월세
    private Integer minMan ; // 최소 관리비
    private Integer maxMan ; // 최대 관리비
    private Integer minDep ; // 최소 보증금
    private Integer maxDep ; // 최대 보증금

    // 회원 맞춤 조건
    private boolean newhouse; // 신축
    private boolean full ; // 풀옵션
    private boolean debt ; // 대출유무
    private boolean elevator ; // 엘리베이터
    private boolean pet ; // 반려동물
    private boolean security ;// 보안기능
    private boolean parking ; // 주차장
    private boolean south ; // 남향
    private boolean bug ; // 벌레 퇴치 업체 유ㅜ
    private boolean woman ;// 여성전용
    private boolean forest ; // 숲 view
    private boolean river ; // 리버 view
    private boolean ocean ; // 오션 view
    private boolean city ; // 시티 view

    // 카테고리 맞춤
    private boolean pub ; // 공공기관
    private boolean medic ; // 의료시설
    private boolean conv ; // 편의시설
    private boolean school ;// 학교 주변
    private boolean teen ; // 10대 거주
    private boolean twen ; // 20대 거주
    private boolean thirty ; // 30대 거주
    private boolean fourth ; // 40대 거주
    private boolean fifty ; // 50대 거주
    private boolean sixty ; // 60대 거주
    private boolean rocket ; // 로켓배송
    private boolean flat ; // 경사 완만
    private boolean subway ; // 역세권
    private boolean park ;// 공원
    private boolean hodi ; // 주택지구

    private static ModelMapper modelMapper = new ModelMapper();

    //Dto -> Entity (insert)
    public MapFilter createReEs(){
        return modelMapper.map(this, MapFilter.class);
    }

    // Entity -> Dto (view)
    public static ReMncsDto of(MapFilter mapFilter){
        return modelMapper.map(mapFilter, ReMncsDto.class);
    }


}
