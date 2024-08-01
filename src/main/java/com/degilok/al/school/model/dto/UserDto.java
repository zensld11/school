package com.degilok.al.school.model.dto;

import com.degilok.al.school.enums.Post;

public record UserDto(
        String name,
        String surname,
        String email,
        String password,
        Post usersPost
) {
}
