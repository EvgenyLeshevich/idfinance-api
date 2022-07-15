package com.evgeniy.idfinance.mapper;

import com.evgeniy.idfinance.database.entity.Cryptocurrency;
import com.evgeniy.idfinance.dto.CryptocurrencyDto;
import org.springframework.stereotype.Component;

@Component
public class CryptocurrencyEditMapper implements Mapper<CryptocurrencyDto, Cryptocurrency> {

    @Override
    public Cryptocurrency map(CryptocurrencyDto dto) {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        copy(dto, cryptocurrency);

        return cryptocurrency;
    }

    private void copy(CryptocurrencyDto dto, Cryptocurrency entity) {
        entity.setPrice(dto.getPrice());
    }
}
