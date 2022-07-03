package EZHome.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.OneToOne;

@Getter @Setter @ToString
public class ReMncsDto { // 기본 Dto
    private String id;  // 필터 정보를 저장하기 위한 기본키

    private String retrType;    // 매매 유형(전, 월, 매)

    private String rehouseType; // 방 유형(원룸 등등)

    private Integer reFlr;   // 층수

    private Integer reExtent;   // 평 수

    private Integer reMon_price;    // 월세

    private Integer reAdmn_fee; // 관리비

    private Integer reDeposit; // 보증금

    // 맞춤 Dto
    private boolean reNew ; // 신축
    private boolean reFull ; // 풀옵션
    private boolean reDebt ; // 대출유무
    private boolean reElvtr ; // 엘리베이터
    private boolean rePet ; //  발련동물
    private boolean reScrty ; // 보안기능
    private boolean reParking ; // 주차장
    private boolean reSouth ; // 남향
    private boolean reBug; // 벌레 퇴치 업체
    private boolean reWoman; // 여성전용
    private boolean reForest ; // 숲 view
    private boolean reRiver ; // 강 vide ;
    private boolean reOcean ; // 오션 view
    private boolean reCity ; // 도시 view

    // 커스텀 Dto
    private boolean rePublic ; //공공기관(경찰서, 은행 등)
    private boolean reMedic ; //의료시설(병원, 약국)
    private boolean reCnvn; // 편의시설(시장, 편의점, 운동시설)
    private boolean reSchol ; // 학교(초등, 중등, 고등)
    private boolean reTeen ; // 10대 거주
    private boolean reTwen ; // 20대 거주
    private boolean reThirty; // 30대 거주
    private boolean reFourty; // 40대 거주
    private boolean reFifty; // 50대 거주
    private boolean reSixty; // 60대 거주
    private boolean reRocket ; // 로캣배송
    private boolean reFlat ; // 경사완만
    private boolean reSubway ; // 역세권
    private boolean rePark; // 공원
    private boolean reRsdnt_Area ; // 주택가




}
