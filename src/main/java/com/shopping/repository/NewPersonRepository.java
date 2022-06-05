package com.shopping.repository;

import com.shopping.entity.NewPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewPersonRepository extends JpaRepository<NewPerson, String> {

    // 이름순으로 조회
    List<NewPerson> findByOrderByNameAsc();

    // 거주지로 조회
    List<NewPerson> findNewPersonByAddress(String address);
//
    // 급여 내림차순 조회
    List<NewPerson> findByOrderBySalaryDesc();

//    // @Query를 사용하여 급여 500이상만을 조회하시오
//    @Query(value = " select * from New_Person where salary >= :leastSalary ")
//    List<NewPerson> findByLeastSalary(@Param("leastSalary") int leastSalary);
}
