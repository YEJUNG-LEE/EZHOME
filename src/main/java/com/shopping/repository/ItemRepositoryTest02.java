package com.shopping.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shopping.constant.ItemSellStatus;
import com.shopping.entity.Item;
import com.shopping.entity.QItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ItemRepositoryTest02 {

    @Autowired // null인 객체를 외부에서 주입(injection) 해주는 어노테이션
    ItemRepository itemRepository;

    // 샘플용 데이터 10개만 생성해 줍니다.
    private void createItemTestMany(){
        String[] fruit = {"사과", "배", "오렌지"};
        String[] description = {"달아요", "맛있어요", "맛없어요", "떫어요"};
        int[] stock = {100,200,300,400};
        int[] price = {111,222,333,444,555};

        for (int i = 1; i <= 10; i++) {
            Item item = new Item();


            item.setItemNm(fruit[i % fruit.length]);
            item.setPrice(price[i % price.length]);
            item.setItemDetail(description[i % description.length]);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(stock[i % stock.length]);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
            System.out.println(savedItem.toString());
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest(){
        this.createItemTestMany();
        List<Item> itemList = itemRepository.findByItemNm("오렌지");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }


    @Test
    @DisplayName("가격 less than 테스트하기")
    public void findByPriceLessThan(){
        List<Item> itemList = itemRepository.findByPriceLessThan(300);
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }


    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    public void findByPriceLessThanOrderByPriceDesc(){
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(300);
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("이름순으로 정렬하기 테스트")
    public void findByNameOrderByNameDesc(){

    }

    @Test
    @DisplayName("@Query를 사용한 상품 조회 테스트")
    public void findByItemDetail(){
        List<Item> itemList = itemRepository.findByItemDetail("달콤해요");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
    @Test
    @DisplayName("@Query를 사용한 상품 조회 테스트")
    public void findByItemDetail2(){
        List<Item> itemList = itemRepository.findByItemDetail2("어");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @PersistenceContext // JPA가 동작하는 영속성 작업
    EntityManager em;

    @Test
    @DisplayName("query Dsl Test01")
    public void queryDslTest01(){
        // JPAQueryFactory : 쿼리를 만들어 주는 클래스
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        // Item Entity에서 판매중인 상품 들을 가격 역순으로 출력해봅니다.
        // like 연사자로 데이터 필터 검색할 겁니다.
        QItem qitem = QItem.item;
        JPAQuery<Item> query = queryFactory
                .selectFrom(qitem)
                .where(qitem.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(qitem.itemDetail.like("%" + "아" + "%"))
                .orderBy(qitem.price.desc());

        List<Item> itemList = query.fetch();

        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
}
