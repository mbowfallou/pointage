package com.groupeisi.dao;

import com.groupeisi.entities.ProfesseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfesseurRepository extends JpaRepository<ProfesseurEntity, Integer> {
    ProfesseurEntity findByEmailIgnoreCase(String email);
    //ProfesseurEntity findByUsernameIgnoreCase (String username);
    List<ProfesseurEntity> findByNomIgnoreCase(String nom);
    List<ProfesseurEntity> findByPrenomIgnoreCase(String prenom);
    List<ProfesseurEntity> findByPrenomIgnoreCaseAndNomIgnoreCase(String prenom, String nom);
    //List<ProfesseurEntity> findByPrenomIgnoreCaseOrNomIgnoreCase(String prenom_ou_nom);
    //List<ProfesseurEntity> findByEtat(int etat);
}
