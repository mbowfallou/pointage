package com.groupeisi.controller;

import com.groupeisi.dto.Professeur;
import com.groupeisi.service.ProfesseurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/profs")
@AllArgsConstructor
public class ProfesseurRestController {
    @Autowired
    private ProfesseurService professeurService;

    // Get All Users
    @GetMapping
    public List<Professeur> getProfesseurs(){
        return professeurService.getProfesseurs();
    }

    // Get One User By his ID
    @GetMapping("/{id}")
    public Professeur getProfesseur(@PathVariable("id") int id){
        return professeurService.getProfesseur(id);
    }

    // Get One User By his Firstname
    @GetMapping("/prenom/{prenom}")
    public List<Professeur> getProfesseurByFirstname(@PathVariable("prenom") String firstname){
        return professeurService.getProfesseurByFirstname(firstname);
    }

    // Get One User By his Lastname
    @GetMapping("/nom/{nom}")
    public List<Professeur> getProfesseurByLastname(@PathVariable("nom") String lastname){
        return professeurService.getProfesseurByLastname(lastname);
    }

    // Get One User By his Email
    @GetMapping("/email/{email}")
    public Professeur getProfesseurByEmail(@PathVariable("email") String email){
        return professeurService.getProfesseurByEmail(email);
    }

    // Get One User By First and Last Name
    @GetMapping("/nomcomplet/{prenom}/{nom}")
    public List<Professeur> getProfesseurByPrenomAndNom(@PathVariable("prenom") String firstname, @PathVariable("nom") String lastname){
        return professeurService.getProfesseurByPrenomAndNom(firstname, lastname);
    }

    // Save A User
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Professeur createProfesseur(@Valid @RequestBody Professeur professeur){
        return professeurService.createProfesseur(professeur);
    }

    // Update A User By his ID
    @PutMapping("/{id}")
    public Professeur updateProfesseur(@PathVariable("id") int id, @Valid @RequestBody Professeur professeur){
        return professeurService.updateProfesseur(id, professeur);
    }

    // Remove A User By his ID
    @DeleteMapping("/{id}")
    public void deleteProfesseur(@PathVariable("id") int id){
        professeurService.deleteProfesseur(id);
    }
}
