package test.technical.inditex.com.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PriceDto {

    private LocalDateTime currentDate;

    private Long brandId;

    private String brandName;

    private Integer priceList;

    private Integer productId;

    private Double price;

    private String curr;
}
