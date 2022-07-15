package com.evgeniy.idfinance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptocurrencyDto {

    private Long id;

    private String symbol;

    @JsonProperty("price_usd")
    private BigDecimal price;
}
