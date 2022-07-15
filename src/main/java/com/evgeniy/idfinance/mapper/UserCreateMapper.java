package com.evgeniy.idfinance.mapper;

import com.evgeniy.idfinance.database.entity.User;
import com.evgeniy.idfinance.dto.UserCreateDto;
import com.evgeniy.idfinance.service.CryptocurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateMapper implements Mapper<UserCreateDto, User> {

    private final CryptocurrencyService cryptocurrencyService;

    @Override
    public User map(UserCreateDto dto) {
        User user = new User();
        copy(dto, user);

        return user;
    }

    private void copy(UserCreateDto dto, User user) {
        user.setUsername(dto.getUsername());
        user.setCryptoSymbol(dto.getCryptoSymbol());
        user.setCryptoPrice(cryptocurrencyService.findPriceBySymbol(dto.getCryptoSymbol()).get());
    }
}
