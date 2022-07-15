package com.evgeniy.idfinance.service;

import com.evgeniy.idfinance.database.repository.CryptocurrencyRepository;
import com.evgeniy.idfinance.dto.CryptocurrencyDto;
import com.evgeniy.idfinance.mapper.CryptocurrencyEditMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CryptocurrencyService {

    private final String URL = "https://api.coinlore.net/api/ticker/";
    private final RestTemplate restTemplate;
    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final CryptocurrencyEditMapper cryptocurrencyEditMapper;

    @Transactional
    public void updateCryptocurrencies() {
        String ids = "90,80,48543";
        ResponseEntity<List<CryptocurrencyDto>> responseEntity = restTemplate.exchange(
                URL + "?id=" + ids,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CryptocurrencyDto>>() {
                }
        );
        var cryptocurrencyDtoList = responseEntity.getBody();

        if (cryptocurrencyDtoList != null) {
            cryptocurrencyDtoList.forEach(dto ->
                    cryptocurrencyRepository.findById(dto.getId())
                            .map(entity -> cryptocurrencyEditMapper.map(dto, entity))
                            .map(cryptocurrency ->
                                    cryptocurrencyRepository.updatePrice(dto.getPrice(), dto.getId()))
            );
        }
    }
}
