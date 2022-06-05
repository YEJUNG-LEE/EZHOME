package com.shopping.repository;

import com.shopping.entity.NewPerson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NewPersonRepositoryTest02 {
    @Autowired
    NewPersonRepository newPersonRepository;

    @Test
    @DisplayName("NewPerson_Test")
    public void createNewPersonTestMany(){
        String[] person = {"김철수", "이다한", "안치국", "송치국", "권순헌", "이예중", "최유진", "박소현", "김도은", "백주현"};
        String[] addressList = {"구로", "성수", "마포", "쌍용", "불당", "영등포", "마포", "동남", "중랑", "대방"};
        for (int i = 1; i <= 10; i++) {
            NewPerson newPerson = new NewPerson();
            String id = "NewPerson_" + i;
            String name = person[i-1];
            String address = addressList[i-1];
            Integer salary = 100*i;

            newPerson.setId(id);
            newPerson.setName(name);
            newPerson.setAddress(address);
            newPerson.setSalary(salary);

            NewPerson savedNP = newPersonRepository.save(newPerson);
            System.out.println(savedNP.toString());
        }
    }


    @Test
    @DisplayName("이름순으로 정렬하기")
    public void findByOrderByNameAsc(){
        List<NewPerson> npList = newPersonRepository.findByOrderByNameAsc();
        for(NewPerson newPerson : npList){
            System.out.println(newPerson.toString());
        }
    }

    @Test
    @DisplayName("거주지가 마포인 사람 조회하기")
    public void findNewPersonByAddress(){
        List<NewPerson> npList = newPersonRepository.findNewPersonByAddress("마포");
        for(NewPerson newPerson : npList){
            System.out.println(newPerson.toString());
        }
    }


    @Test
    @DisplayName("급여가 높은 순으로 정렬하기")
    public void findNewPersonOrderBySalaryDesc(){
        List<NewPerson> npList = newPersonRepository.findByOrderBySalaryDesc();
        for(NewPerson newPerson : npList){
            System.out.println(newPerson.toString());
        }
    }

//    @Test
//    @DisplayName("급여 500이상")
//    public void findByLeastSalary(){
//        List<NewPerson> npList = newPersonRepository.findByLeastSalary(500);
//        for(NewPerson newPerson : npList){
//            System.out.println(newPerson.toString());
//        }
//    }

}
