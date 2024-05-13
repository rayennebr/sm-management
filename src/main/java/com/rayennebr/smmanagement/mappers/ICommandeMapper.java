package com.rayennebr.smmanagement.mappers;

import com.rayennebr.smmanagement.entities.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ICommandeMapper {
    void matoUpdate(Commande commande, @MappingTarget Commande commandToUpdate);
}
