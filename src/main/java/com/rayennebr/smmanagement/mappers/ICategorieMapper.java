package com.rayennebr.smmanagement.mappers;

import com.rayennebr.smmanagement.entities.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ICategorieMapper {
    void mapToUpdate(Categorie categorie, @MappingTarget Categorie categorieToUpdate);
}
