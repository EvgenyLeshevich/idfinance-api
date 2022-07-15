package com.evgeniy.idfinance.mapper;

import com.evgeniy.idfinance.database.entity.User;
import com.evgeniy.idfinance.dto.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User user) {
        return new UserReadDto(
                user.getId(),
                user.getUsername(),
                user.getCryptoSymbol(),
                user.getCryptoPrice()
        );
    }
}
