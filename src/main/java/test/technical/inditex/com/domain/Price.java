package test.technical.inditex.com.domain;

import lombok.*;

import java.time.LocalDateTime;
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private Long brandId;

    private String brandName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long priceList;

    private Long productId;

    private Integer priority;

    private Double price;

    private String curr;
}
