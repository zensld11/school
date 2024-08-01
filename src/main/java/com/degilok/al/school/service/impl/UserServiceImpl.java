package com.degilok.al.school.service.impl;

import com.degilok.al.school.model.User;
import com.degilok.al.school.model.dto.UserDto;
import com.degilok.al.school.repository.UserRepository;
import com.degilok.al.school.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(UserDto userDto) {
        User user = new User();

        user.setName(userDto.name());
        user.setSurname(userDto.surname());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setUsersPost(userDto.usersPost());

        return userRepository.save(user);
    }

    @Override
    public User authUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);

    }
}