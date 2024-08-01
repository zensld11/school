package com.degilok.al.school.service.impl;

import com.degilok.al.school.enums.Role;
import com.degilok.al.school.model.User;
import com.degilok.al.school.model.dto.UserDto;
import com.degilok.al.school.repository.UserRepository;
import com.degilok.al.school.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleServiceImpl roleService;

    public UserServiceImpl(UserRepository userRepository, RoleServiceImpl roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }


    @Override
    public User createUser(UserDto userDto) {
        User user = new User();

        user.setName(userDto.name());
        user.setSurname(userDto.surname());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setUsersRole(userDto.usersRole());

        return userRepository.save(user);
    }

    @Override
    public User authUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User deleteUser(String email, String userEmailCurrent){

        Role userCurrentRole = roleService.getUserRole(userEmailCurrent);

        if (userCurrentRole != Role.ADMINISTRATOR){
            throw new SecurityException("Недостаточно прав для удаления пользователя");
        }
        User userToDelete = userRepository.findByEmail(email);
        if (userToDelete != null){
            userRepository.delete(userToDelete);
            return userToDelete;
        }else {
            return null;
        }
    }

}