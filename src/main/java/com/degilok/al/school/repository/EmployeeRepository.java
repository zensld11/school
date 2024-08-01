package com.degilok.al.school.repository;

import com.degilok.al.school.model.Employee;
import com.degilok.al.school.model.User;
import com.degilok.al.school.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    User delete(String email);
}