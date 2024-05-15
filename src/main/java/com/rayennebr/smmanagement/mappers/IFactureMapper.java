package com.rayennebr.smmanagement.mappers;

import com.rayennebr.smmanagement.entities.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IFactureMapper {
    void mapToUpdate(Facture facture, @MappingTarget Facture factureToUpdate);
}
