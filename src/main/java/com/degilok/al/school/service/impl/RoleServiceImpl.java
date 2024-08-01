package com.degilok.al.school.service.impl;

import com.degilok.al.school.enums.Role;
import com.degilok.al.school.model.User;
import com.degilok.al.school.repository.EmployeeRepository;
import com.degilok.al.school.repository.UserRepository;
import com.degilok.al.school.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final RoleServiceImpl roleService;

    public RoleServiceImpl(UserRepository userRepository, EmployeeRepository employeeRepository, RoleServiceImpl roleService) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.roleService = roleService;
    }

    @Override
    public Role getUserRole(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getUsersRole();
        } else {
            throw new IllegalArgumentException("Пользователь с данным email не найден");
        }
    }
}