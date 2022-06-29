package EZHome.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/*
java.util.Optional
NPE는 NullPointerException의 줄인 말입니다.
Optional<T> 클래스는 Java8 이상의 버전에서 NPE를 방지할 수 있도록 도와 줍니다. 
만약 somedata 데이터가 절대로 null 아니라고 판단이 되는 경우에 Optional.of(somedata)를 사용할 수 있습니다.
만약 somedata 데이터가 Null인 경우에는  NullPointerException이 발생합니다.
*/
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = "";
        if(authentication != null){
            userId = authentication.getName();
        }
        return Optional.of(userId);
    }

}