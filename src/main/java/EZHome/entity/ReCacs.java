package EZHome.entity;

import EZHome.dto.ReFormDto;
import EZHome.dto.ReMncsDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="ReCacs") // 카테고리 매물
@Getter @Setter @ToString
public class ReCacs extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="caid")
    private Long id ; // 매물 카테고리 기본키(Fk)

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
    private boolean reMainroad; // 대로변
    private boolean reRocket ; // 로캣배송
    private boolean reFlat ; // 경사완만
    private boolean reSubway ; // 역세권
    private boolean rePark; // 공원
    private boolean reRsdnt_Area ; // 주택가

    @OneToOne()
    @JoinColumn(name = "reid", unique = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ReEs reEs;

    public Map<String, Integer> compare(ReMncsDto reMncsDto, Map<String, Integer> match) {
        int select = 0;    // 몇 개를 선택했는지 확인하는 변수
        int correct = 0;   // 몇 개가 맞는지 확인하는 변수
        if(reMncsDto.isPub()){select += 1; if(this.isRePublic()){correct += 1;}}
        if(reMncsDto.isMedic()){select += 1; if(this.isReMedic()){correct += 1;}}
        if(reMncsDto.isConv()){select += 1; if(this.isReCnvn()){correct += 1;}}
        if(reMncsDto.isSchool()){select += 1; if(this.isReSchol()){correct += 1;}}
        if(reMncsDto.isTeen()){select += 1; if(this.isReTeen()){correct += 1;}}
        if(reMncsDto.isTwen()){select += 1; if(this.isReTwen()){correct += 1;}}
        if(reMncsDto.isThirty()){select += 1; if(this.isReThirty()){correct += 1;}}
        if(reMncsDto.isFourty()){select += 1; if(this.isReFourty()){correct += 1;}}
        if(reMncsDto.isFifty()){select += 1; if(this.isReFifty()){correct += 1;}}
        if(reMncsDto.isSixty()){select += 1; if(this.isReSixty()){correct += 1;}}
        if(reMncsDto.isBoulevard()){select += 1; if(this.isReMainroad()){correct += 1;}}
        if(reMncsDto.isRocket()){select += 1; if(this.isReRocket()){correct += 1;}}
        if(reMncsDto.isFlat()){select += 1; if(this.isReFlat()){correct += 1;}}
        if(reMncsDto.isSubway()){select += 1; if(this.isReSubway()){correct += 1;}}
        if(reMncsDto.isPark()){select += 1; if(this.isRePark()){correct += 1;}}
        if(reMncsDto.isHodi()){select += 1; if(this.isReRsdnt_Area()){correct += 1;}}

        if(match.containsKey("select")){
            int oldSelect = match.get("select");
            match.put("select", oldSelect + select);
        }else{
            match.put("select", select);
        }
        if(match.containsKey("select")){
            int oldCorrect = match.get("correct");
            match.put("correct", oldCorrect + correct);
        }else{
            match.put("correct", correct);
        }

        return match;
    }

    public Map<String, Integer> compareOne(ReFormDto reFormDto, Map<String, Integer> match) {
        int select = 0;    // 몇 개를 선택했는지 확인하는 변수
        int correct = 0;   // 몇 개가 맞는지 확인하는 변수
        if(reFormDto.isRePublic()){select += 1; if(this.isRePublic()){correct += 1;}}
        if(reFormDto.isReMedic()){select += 1; if(this.isReMedic()){correct += 1;}}
        if(reFormDto.isReCnvn()){select += 1; if(this.isReCnvn()){correct += 1;}}
        if(reFormDto.isReSchol()){select += 1; if(this.isReSchol()){correct += 1;}}
        if(reFormDto.isReTeen()){select += 1; if(this.isReTeen()){correct += 1;}}
        if(reFormDto.isReTwen()){select += 1; if(this.isReTwen()){correct += 1;}}
        if(reFormDto.isReThirty()){select += 1; if(this.isReThirty()){correct += 1;}}
        if(reFormDto.isReFourty()){select += 1; if(this.isReFourty()){correct += 1;}}
        if(reFormDto.isReFifty()){select += 1; if(this.isReFifty()){correct += 1;}}
        if(reFormDto.isReSixty()){select += 1; if(this.isReSixty()){correct += 1;}}
        if(reFormDto.isReMainroad()){select += 1; if(this.isReMainroad()){correct += 1;}}
        if(reFormDto.isReRocket()){select += 1; if(this.isReRocket()){correct += 1;}}
        if(reFormDto.isReFlat()){select += 1; if(this.isReFlat()){correct += 1;}}
        if(reFormDto.isReSubway()){select += 1; if(this.isReSubway()){correct += 1;}}
        if(reFormDto.isRePark()){select += 1; if(this.isRePark()){correct += 1;}}
        if(reFormDto.isReRsdnt_Area()){select += 1; if(this.isReRsdnt_Area()){correct += 1;}}

        if(match.containsKey("select")){
            int oldSelect = match.get("select");
            match.put("select", oldSelect + select);
        }else{
            match.put("select", select);
        }
        if(match.containsKey("select")){
            int oldCorrect = match.get("correct");
            match.put("correct", oldCorrect + correct);
        }else{
            match.put("correct", correct);
        }

        return match;
    }
}
