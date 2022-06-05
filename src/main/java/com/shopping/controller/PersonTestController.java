package com.shopping.controller;

import com.shopping.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonTestController {
    @GetMapping(value="/person")
    public Person test(){
        Person bean = new Person();
        String id = "LYJ";
        String name = "이예중";
        String address = "서울특별시 구로구";
        int salary = 45000000;
        bean.setId(id);
        bean.setName(name);
        bean.setAddress(address);
        bean.setSalary(salary);
        return bean;
    }
}
