package test.technical.inditex.com.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PriceRequestDto {
    private LocalDateTime currentDate;

    private Integer brandId;

    private Integer productId;
}
