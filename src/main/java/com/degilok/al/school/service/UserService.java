package com.degilok.al.school.service;

import com.degilok.al.school.model.User;
import com.degilok.al.school.model.dto.UserDto;

public interface UserService {

    User createUser(UserDto userDto);

    User authUser(String email, String password);
}
