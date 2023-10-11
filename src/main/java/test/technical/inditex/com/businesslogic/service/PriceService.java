package test.technical.inditex.com.businesslogic.service;


import test.technical.inditex.com.domain.Price;

import java.time.LocalDateTime;

public interface PriceService {

    Price getPricesByDateProductAndBrand(LocalDateTime dateApplication, Integer idProduct, int idCadena);
}
