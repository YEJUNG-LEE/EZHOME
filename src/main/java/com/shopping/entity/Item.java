package com.shopping.entity;

import com.shopping.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Item") // name 속성은 실제 테이블 이름이 됩니다.
@Getter @Setter @ToString
public class Item {
    @Id
    @Column(name = "item_id")
    // AUTO는 JPA 구현체가 자동으로 기본키 생성 전략을 결정합니다.
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;    // 상품 코드(기본 키역할)

    // 최대 길이는 50인데, null값이 들어가면 안됩니다.(필수입력사항 입니다.)
    @Column(nullable = false, length = 50)
    private String itemNm; // 상품 이름

    @Column(nullable = false, name="price")
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고 구수량

    @Lob // CLOB(Character Large OBject), BLOB(Binary Large OBject)
    @Column(nullable = false)
    private String itemDetail;  // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매 상태


    private LocalDateTime regTime; // 등록 상태
    private LocalDateTime updateTime; // 수정 시간
}
