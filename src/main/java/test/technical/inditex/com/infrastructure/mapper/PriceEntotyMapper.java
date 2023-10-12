package test.technical.inditex.com.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import test.technical.inditex.com.businesslogic.domain.Price;
import test.technical.inditex.com.infrastructure.entity.PriceEntity;


import java.util.List;
@Mapper
public interface PriceEntotyMapper {
    PriceEntotyMapper INSTANCE = Mappers.getMapper(PriceEntotyMapper.class);
    List<Price> toDomainList(List<PriceEntity> listEntity);
    @Mapping(target = "brandName", constant = "ZARA")
    Price toDomain(PriceEntity entity);

}
