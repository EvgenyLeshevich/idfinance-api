package com.evgeniy.idfinance.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class UserCreateDto {

    @NotBlank
    String username;

    @NotBlank
    String cryptoSymbol;
}
