package test.technical.inditex.com.businesslogic.domain;

import lombok.*;

import java.time.LocalDateTime;
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private Integer brandId;

    private String brandName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Integer productId;

    private Integer priority;

    private Double price;

    private String curr;
}
