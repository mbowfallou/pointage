package com.groupeisi.mapping;

import com.groupeisi.dto.Professeur;
import com.groupeisi.entities.ProfesseurEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfesseurMapper {
    Professeur toProfesseur(ProfesseurEntity professeurEntity);
    ProfesseurEntity fromProfesseur(Professeur professeur);
}
