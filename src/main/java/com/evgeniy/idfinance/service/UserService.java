package com.evgeniy.idfinance.service;

import com.evgeniy.idfinance.database.repository.UserRepository;
import com.evgeniy.idfinance.dto.UserCreateDto;
import com.evgeniy.idfinance.dto.UserReadDto;
import com.evgeniy.idfinance.mapper.UserCreateMapper;
import com.evgeniy.idfinance.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserReadMapper userReadMapper;

    @Transactional
    public UserReadDto create(UserCreateDto userCreateDto) {
        return Optional.of(userCreateDto)
                .map(userCreateMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }
}
