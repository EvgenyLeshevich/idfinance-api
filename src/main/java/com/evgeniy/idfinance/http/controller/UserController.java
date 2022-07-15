package com.evgeniy.idfinance.http.controller;

import com.evgeniy.idfinance.dto.UserCreateDto;
import com.evgeniy.idfinance.dto.UserReadDto;
import com.evgeniy.idfinance.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create user")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@Validated @RequestBody UserCreateDto user) {
        return userService.create(user);
    }
}
