package test.technical.inditex.com.businesslogic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.technical.inditex.com.businesslogic.repository.PriceRepository;
import test.technical.inditex.com.businesslogic.service.PriceService;
import test.technical.inditex.com.domain.Price;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @Override
    public Price getPricesByDateProductAndBrand(LocalDateTime dateApplication, Integer idProduct, int idCadena) {
        List<Price> listPrice = priceRepository.findPricesByDateProductAndBrand(dateApplication, idProduct, idCadena);
        Optional<Price> priceOptional = Optional.empty();
        if(hasDuplicatePricesOnSameDate(listPrice)) {
            priceOptional = listPrice.stream()
                    .max(Comparator.comparingInt(Price::getPriority));
        }
        return priceOptional.orElseGet(() -> listPrice.get(0));
    }

    private boolean hasDuplicatePricesOnSameDate (List<Price> listPrice) {
        return listPrice.size()>1;
    }
}
