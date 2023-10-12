package test.technical.inditex.com.presentation.mapper;

import org.mapstruct.Mapper;
import test.technical.inditex.com.businesslogic.domain.Price;
import test.technical.inditex.com.presentation.dto.PriceDto;
import java.time.LocalDateTime;


@Mapper(componentModel = "spring", uses={MapperUtils.class})
public interface PriceDtoMapper {
    PriceDto toDto(LocalDateTime currentDate, Price price);

}
