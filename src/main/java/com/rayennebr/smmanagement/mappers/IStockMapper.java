package com.rayennebr.smmanagement.mappers;

import com.rayennebr.smmanagement.entities.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IStockMapper {
    void mapToUpdate(Stock stock, @MappingTarget Stock stockToUpdate);
}
