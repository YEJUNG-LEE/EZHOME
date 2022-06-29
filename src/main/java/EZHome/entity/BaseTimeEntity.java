package EZHome.entity;

<<<<<<< HEAD

=======
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

<<<<<<< HEAD
// Entity에 대하여 AuditingEntityListener를 이용하여 리스닝할 겁니다.
@EntityListeners(value={AuditingEntityListener.class})
@MappedSuperclass
@Getter @Setter
public abstract class BaseTimeEntity {
    @CreatedDate // 엔터티 생성시 시간을 자동으로 기록할께요.
    @Column(updatable = false) // Entity 수정시 같이 갱신하지 않을 겁니다.
    private LocalDateTime regTime ; //= LocalDateTime.now();

    @LastModifiedDate // 엔터티 수정시 시간을 자동으로 기록할께요.
    private LocalDateTime updateTime ;
=======
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter @Setter

public abstract class BaseTimeEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regTime;  // 등록 날짜

    @LastModifiedDate
    private LocalDateTime updateTime;
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
}
