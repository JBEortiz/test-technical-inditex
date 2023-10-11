package test.technical.inditex.com.infrastructure.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.technical.inditex.com.businesslogic.repository.PriceRepository;
import test.technical.inditex.com.domain.Price;
import test.technical.inditex.com.infrastructure.entity.PriceEntity;
import test.technical.inditex.com.infrastructure.mapper.PriceEntotyMapper;
import test.technical.inditex.com.infrastructure.repository.SpringDataPriceRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceEntotyMapper priceEntotyMapper;
    private final SpringDataPriceRepository springDataPriceRepository;



    @Override
    public List<Price> findPricesByDateProductAndBrand(LocalDateTime dateApplication, Integer idProduct, int idCadena) {
       return priceEntotyMapper.toDomainList(springDataPriceRepository.findPricesByProductIdAndBrandIdAndDate(idProduct, idCadena, Timestamp.valueOf(dateApplication)));
    }
}
