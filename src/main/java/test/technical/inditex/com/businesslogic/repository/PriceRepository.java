package test.technical.inditex.com.businesslogic.repository;



import test.technical.inditex.com.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findPricesByDateProductAndBrand(LocalDateTime dateApplication, Integer idProduct, int idCadena);
}
