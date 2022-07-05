package EZHome.entity;

import EZHome.dto.ReMncsDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="MapFilter")
@Getter @Setter @ToString
public class MapFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="MapF_id")
    private Long id;

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
    private boolean fourty ; // 40대 거주
    private boolean fifty ; // 50대 거주
    private boolean sixty ; // 60대 거주
    private boolean rocket ; // 로켓배송
    private boolean flat ; // 경사 완만
    private boolean subway ; // 역세권
    private boolean park ;// 공원
    private boolean hodi ; // 주택지구

    private boolean boulevard ; //대도로변


    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void addFilter(ReMncsDto reMncsDto){
        this.houseType = houseType; // 매물 유형
        this.trType = trType;   // 매매 유형
        this.minFloor = minFloor;   // 최소 층수
        this.maxFloor = maxFloor;   // 최대 층수
        this.halfUnder = halfUnder; // 반지하
        this.loofTop = loofTop; // 옥탑방
        this.minEx = minEx; // 최소 평수
        this.maxEx = maxEx; // 최대 평수
        this.minMon = minMon; ; // 최소 월세
        this.maxMon = maxMon ; // 최대 월세
        this.minMan = minMan ; // 최소 관리비
        this.maxMan = maxMan ; // 최대 관리비
        this.minDep = minDep ; // 최소 보증금
        this.maxDep = maxDep ; // 최대 보증금

        // 회원 맞춤 조건
        this.newhouse = newhouse; ; // 신축
        this.full = full ; // 풀옵션
        this.debt = debt ; // 대출유무
        this.elevator = elevator ; // 엘리베이터
        this.pet = pet ; // 반려동물
        this.security = security ; // 보안기능
        this.parking = parking ; // 주차장
        this.south = south ; // 남향
        this.bug = bug ; // 벌리 퇴치 업체
        this.woman = woman ; // 여성전용
        this.forest = forest ; // 숲 view
        this.river = river ; // 강 view
        this.ocean = ocean ; // 오션 view
        this.city = city ; // 숲 view

        // 카테고리 맞춤
        this.pub = pub ; // 공공기관
        this.medic = medic ; // 의료시설
        this.conv = conv ; // 편의시설
        this.school = school ; // 학교 주변
        this.teen = teen ; // 10대 거주
        this.twen = twen ; // 20대 거주
        this.thirty = thirty ; // 30대 거주
        this.fourty = fourty   ; // 40대 거주
        this.fifty = fifty ; // 50대 거주
        this.sixty = sixty ; // 60대 거주
        this.rocket = rocket ; // 로켓배송
        this.flat = flat  ; // 경사 완만
        this.subway = subway  ; // 역세권
        this.park = park  ; // 공원
        this.hodi = hodi  ; // 주택지구
        this.boulevard = boulevard; // 도로변
    }






}
