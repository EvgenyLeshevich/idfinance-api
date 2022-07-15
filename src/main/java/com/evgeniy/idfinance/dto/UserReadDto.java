package com.evgeniy.idfinance.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class UserReadDto {
    Long id;
    String username;
    String cryptoSymbol;
    BigDecimal cryptoPrice;
}
