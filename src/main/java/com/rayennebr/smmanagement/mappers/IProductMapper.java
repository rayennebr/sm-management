package com.rayennebr.smmanagement.mappers;

import com.rayennebr.smmanagement.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IProductMapper {

    void mapForUpdate(Product product , @MappingTarget Product updatedProduct);
}
