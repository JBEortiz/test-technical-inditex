package test.technical.inditex.com.businesslogic.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import test.technical.inditex.com.businesslogic.repository.PriceRepository;
import test.technical.inditex.com.businesslogic.service.PriceService;
import test.technical.inditex.com.businesslogic.domain.Price;

import java.time.LocalDateTime;
import java.util.Comparator;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @Override
    public Price getPricesByDateProductAndBrand(LocalDateTime dateApplication, Integer idProduct, int brandId) {
        return priceRepository.findPricesByDateProductAndBrand(dateApplication, idProduct, brandId).stream()
                    .max(Comparator.comparingInt(Price::getPriority)).orElseThrow(() -> new ObjectNotFoundException(HttpStatus.NOT_FOUND, " Price with was not found"));

    }


}
