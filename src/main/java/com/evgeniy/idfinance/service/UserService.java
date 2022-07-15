package com.evgeniy.idfinance.service;

import com.evgeniy.idfinance.database.repository.UserRepository;
import com.evgeniy.idfinance.dto.UserCreateDto;
import com.evgeniy.idfinance.dto.UserReadDto;
import com.evgeniy.idfinance.mapper.UserCreateMapper;
import com.evgeniy.idfinance.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserReadMapper userReadMapper;
    private final CryptocurrencyService cryptocurrencyService;

    @Transactional
    public UserReadDto create(UserCreateDto userCreateDto) {
        return Optional.of(userCreateDto)
                .map(userCreateMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    public void checkUserPrice() {
        var userList = userRepository.findAll();

        if (!userList.isEmpty()) {
            userList.forEach(user -> {
                        var actualPrice = cryptocurrencyService.findPriceBySymbol(user.getCryptoSymbol());
                        var userCryptoPrice = user.getCryptoPrice();
                        var result = BigDecimal.valueOf(100).multiply(
                                (actualPrice.get().subtract(userCryptoPrice).divide(userCryptoPrice, 2, RoundingMode.HALF_UP))
                        );
                        if (result.abs().compareTo(BigDecimal.valueOf(1)) > 0) {
                            log.warn(String.format("Symbol: %s, Username: %s, Percentage of price change since registration: %.2f%%",
                                    user.getCryptoSymbol(), user.getUsername(), result.abs()));
                        }
                    }
            );
        }
    }
}
