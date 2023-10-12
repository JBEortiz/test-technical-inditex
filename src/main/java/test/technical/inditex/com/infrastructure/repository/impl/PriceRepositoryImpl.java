package test.technical.inditex.com.infrastructure.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.technical.inditex.com.businesslogic.repository.PriceRepository;
import test.technical.inditex.com.businesslogic.domain.Price;
import test.technical.inditex.com.infrastructure.mapper.PriceEntotyMapper;
import test.technical.inditex.com.infrastructure.repository.SpringDataPriceRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Repository
public class PriceRepositoryImpl implements PriceRepository {
    private final PriceEntotyMapper priceEntotyMapper;
    private final SpringDataPriceRepository springDataPriceRepository;

    @Override
    public List<Price> findPricesByDateProductAndBrand(LocalDateTime dateApplication, Integer productId, int brandId) {
       return priceEntotyMapper.toDomainList(springDataPriceRepository.findPricesByProductIdAndBrandIdAndDate(productId, brandId, Timestamp.valueOf(dateApplication)));
    }
}
