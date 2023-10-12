package test.technical.inditex.com.businesslogic.repository;

import test.technical.inditex.com.businesslogic.domain.Price;
import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findPricesByDateProductAndBrand(LocalDateTime dateApplication, Integer productId, int brandId);
}
