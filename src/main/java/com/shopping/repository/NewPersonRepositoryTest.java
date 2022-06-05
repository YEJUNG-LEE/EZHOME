package com.shopping.repository;

import com.shopping.entity.NewPerson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewPersonRepositoryTest {
    @Autowired
    NewPersonRepository newPersonRepository;

    @Test
    @DisplayName("NewPerson_Test")
    public void createNewPersonTest(){
        NewPerson newPerson = new NewPerson();
        String id = "abcde";
        String name = "이름이름이름";
        String address = "구로구";
        Integer salary = 1000;

        newPerson.setId(id);
        newPerson.setName(name);
        newPerson.setAddress(address);
        newPerson.setSalary(salary);

        NewPerson savedNP = newPersonRepository.save(newPerson);
        System.out.println(savedNP.toString());
    }
}
