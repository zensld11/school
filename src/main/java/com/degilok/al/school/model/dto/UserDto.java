package com.degilok.al.school.model.dto;

import com.degilok.al.school.enums.Role;

public record UserDto(
        String name,
        String surname,
        String email,
        String password,
        Role usersRole
) {
}
