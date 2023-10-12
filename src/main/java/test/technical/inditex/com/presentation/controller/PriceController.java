package test.technical.inditex.com.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.technical.inditex.com.businesslogic.service.PriceService;
import test.technical.inditex.com.presentation.dto.PriceDto;
import test.technical.inditex.com.presentation.dto.PriceRequestDto;
import test.technical.inditex.com.presentation.mapper.PriceDtoMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("inditex/technical-test")
public class PriceController {
    private final PriceService priceService;
    private final PriceDtoMapper priceDtoMapper;

    @GetMapping("/prices")
    public ResponseEntity<PriceDto> getAll(@RequestBody PriceRequestDto priceRequest) {
        PriceDto priceResponse = priceDtoMapper.toDto(priceRequest.getCurrentDate(),
                priceService.getPricesByDateProductAndBrand(priceRequest.getCurrentDate(), priceRequest.getProductId(), priceRequest.getBrandId()));
        priceResponse.setCurrentDate(priceRequest.getCurrentDate());
        return new ResponseEntity<>(
                priceResponse,
                HttpStatus.OK);
    }

}
