package com.degilok.al.school.service;

import com.degilok.al.school.model.User;
import com.degilok.al.school.model.dto.UserDto;

public interface UserService {

    User createUser(UserDto userDto);

    User authUser(String email, String password);
}

// Регистрация и аутентификация пользователей с различными ролями
//все юзеры должны иметь возможность регистрироваться, авторизоваться



//Админ имеет возможность добавления, редактирования и удаления пользователей
// и управление профилями пользователей