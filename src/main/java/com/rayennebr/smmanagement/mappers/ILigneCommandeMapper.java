package com.rayennebr.smmanagement.mappers;

import com.rayennebr.smmanagement.entities.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ILigneCommandeMapper {
    void mapToUpdate(LigneCommande ligneCommande, @MappingTarget LigneCommande ligneCommandeToUpdate);
}
