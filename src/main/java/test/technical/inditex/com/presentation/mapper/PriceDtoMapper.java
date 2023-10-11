package test.technical.inditex.com.presentation.mapper;

import org.mapstruct.Mapper;
import test.technical.inditex.com.domain.Price;
import test.technical.inditex.com.presentation.dto.PriceDto;


@Mapper
public interface PriceDtoMapper {
    PriceDto toDto(Price price);


}
