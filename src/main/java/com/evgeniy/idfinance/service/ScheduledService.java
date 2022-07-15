package com.evgeniy.idfinance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledService {

    private final CryptocurrencyService cryptocurrencyService;

    @Scheduled(fixedRateString = "${fixedRate}")
    public void startScheduledTasks() {
        cryptocurrencyService.updateCryptocurrencies();
    }
}
