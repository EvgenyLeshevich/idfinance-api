package com.evgeniy.idfinance.database.repository;

import com.evgeniy.idfinance.database.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Cryptocurrency c " +
            "set c.price = :price " +
            "where c.id = :id")
    int updatePrice(BigDecimal price, Long id);
}
