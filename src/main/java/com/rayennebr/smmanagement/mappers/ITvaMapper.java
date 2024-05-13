package com.rayennebr.smmanagement.mappers;

import com.rayennebr.smmanagement.entities.Tva;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ITvaMapper {
    void mapToUpdate(Tva tva, @MappingTarget Tva tvaToUpdate);
}
