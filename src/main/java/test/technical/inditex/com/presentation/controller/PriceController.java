package test.technical.inditex.com.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.technical.inditex.com.businesslogic.service.PriceService;
import test.technical.inditex.com.presentation.dto.PriceDto;
import test.technical.inditex.com.presentation.mapper.PriceDtoMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("inditex/technical-test")
public class PriceController {
    private final PriceService priceService;
    private final PriceDtoMapper priceDtoMapper;

    @GetMapping("/prices/date/{dateApplication}/id-product/{idProduct}/id-cadena/{idCadena}")
    public ResponseEntity<PriceDto> getAll(@PathVariable LocalDateTime dateApplication, @PathVariable Integer idProduct, @PathVariable int idCadena) {
        return new ResponseEntity<>(
                priceDtoMapper.toDto(
                priceService.getPricesByDateProductAndBrand(dateApplication, idProduct, idCadena)),
                HttpStatus.OK);
    }

}
