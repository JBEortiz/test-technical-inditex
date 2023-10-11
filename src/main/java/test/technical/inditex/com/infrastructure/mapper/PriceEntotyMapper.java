package test.technical.inditex.com.infrastructure.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import test.technical.inditex.com.domain.Price;
import test.technical.inditex.com.infrastructure.entity.PriceEntity;


import java.util.List;
@Mapper
public interface PriceEntotyMapper {
    List<Price> toDomainList(List<PriceEntity> listEntity);
    Price toDomain(PriceEntity entity);
    @AfterMapping
    public default void afterMapperPrice(@MappingTarget Price price, PriceEntity priceEntity){
    }
}
