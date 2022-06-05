package com.shopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shopping.entity.Employee;

@RestController // 이 클래스는 컨트롤러로 사용됩니다.
public class EmployeeTestController {
    // Get방식으로 Mapping하겠습니다.

    @GetMapping(value="/employee")
    public Employee test(){
        Employee bean = new Employee();
        bean.setId("yusin");
        bean.setName("김유신");
        bean.setAge(20);
        return bean;
    }
}
