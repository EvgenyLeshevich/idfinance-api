package com.evgeniy.idfinance.mapper;

import com.evgeniy.idfinance.database.entity.Cryptocurrency;
import com.evgeniy.idfinance.dto.CryptocurrencyDto;
import org.springframework.stereotype.Component;

@Component
public class CryptocurrencyReadMapper implements Mapper<Cryptocurrency, CryptocurrencyDto> {
    @Override
    public CryptocurrencyDto map(Cryptocurrency entity) {
        return new CryptocurrencyDto(
                entity.getId(),
                entity.getSymbol(),
                entity.getPrice()
        );
    }
}
