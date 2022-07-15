package com.evgeniy.idfinance.http.controller;

import com.evgeniy.idfinance.dto.CryptocurrencyDto;
import com.evgeniy.idfinance.service.CryptocurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cryptocurrencies")
@RequiredArgsConstructor
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    @Operation(summary = "Get all Cryptocurrencies")
    @GetMapping
    public List<CryptocurrencyDto> findAllCryptocurrency() {
        return cryptocurrencyService.findAllCryptocurrencies();
    }

    @Operation(summary = "Get the price Cryptocurrency by symbol")
    @GetMapping("/{symbol}")
    public BigDecimal findPriceCryptocurrencyBySymbol(@PathVariable("symbol") String symbol) {
        return cryptocurrencyService.findPriceBySymbol(symbol)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
}
