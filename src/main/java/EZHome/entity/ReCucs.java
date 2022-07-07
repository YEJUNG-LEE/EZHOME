 package EZHome.entity;

import EZHome.dto.ReMncsDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

 @Entity
@Table(name="ReCucs") // 커스텀 매물
@Getter @Setter @ToString
public class ReCucs extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cuid")
    private Long id ; //매물 맞춤 기본키(FK)



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

    @OneToOne()
    @JoinColumn(name = "reid", unique = true)
     private ReEs reEs;

     public Map<String, Integer> compare(ReMncsDto reMncsDto, Map<String, Integer> match) {
         int select = 0;    // 몇 개를 선택했는지 확인하는 변수
         int correct = 0;   // 몇 개가 맞는지 확인하는 변수

         // 회원 기본 조건에 선택되어있으면 select에 1추가, 매물에도 있으면 correct에 1추가
         if(reMncsDto.isNewhouse()){select += 1; if(this.isReNew()){correct += 1;}}
         if(reMncsDto.isFull()){select += 1; if(this.isReFull()){correct += 1;}}
         if(reMncsDto.isDebt()){select += 1; if(this.isReDebt()){correct += 1;}}
         if(reMncsDto.isElevator()){select += 1; if(this.isReElvtr()){correct += 1;}}
         if(reMncsDto.isPet()){select += 1; if(this.isRePet()){correct += 1;}}
         if(reMncsDto.isSecurity()){select += 1; if(this.isReScrty()){correct += 1;}}
         if(reMncsDto.isParking()){select += 1; if(this.isReParking()){correct += 1;}}
         if(reMncsDto.isSouth()){select += 1; if(this.isReSouth()){correct += 1;}}
         if(reMncsDto.isBug()){select += 1; if(this.isReBug()){correct += 1;}}
         if(reMncsDto.isWoman()){select += 1; if(this.isReWoman()){correct += 1;}}
         if(reMncsDto.isForest()){select += 1; if(this.isReForest()){correct += 1;}}
         if(reMncsDto.isRiver()){select += 1; if(this.isReRiver()){correct += 1;}}
         if(reMncsDto.isOcean()){select += 1; if(this.isReOcean()){correct += 1;}}
         if(reMncsDto.isCity()){select += 1; if(this.isReCity()){correct += 1;}}



         match.put("select", select);
         match.put("correct", correct);

         return match;
     }
 }
