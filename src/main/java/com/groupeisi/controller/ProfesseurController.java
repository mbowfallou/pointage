package com.groupeisi.controller;

import com.groupeisi.dto.Professeur;
import com.groupeisi.service.ProfesseurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/professeur")
@AllArgsConstructor
public class ProfesseurController {
    private ProfesseurService professeurService;

    // Add a Professor - Form
    @GetMapping("/add")
    public String add(Model model, Professeur professeur){
        model.addAttribute("professeur", professeur);
        return "professeur/add";
    }

    // Add a Professeur - Submission
    @PostMapping("/save")
    public String save(@Valid Professeur professeur, BindingResult result){
        if (result.hasErrors()) {
            return "professeur/add";
        }
        professeur = professeurService.createProfesseur(professeur);

        return "redirect:/professeur/id/" + professeur.getId();
    }

    // Update a Professor - Form
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        Professeur prof = professeurService.getProfesseur(id);
        prof.setPassword("");
        model.addAttribute("professeur", prof);
        return "professeur/edit";
    }

    // Update a Professor - Submission
    @PostMapping("/update/{id}")
    public String updateSubmit(@PathVariable("id") int id, @Valid Professeur professeur, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "professeur/edit";
        }

        professeur = professeurService.updateProfesseur(id, professeur);

        model.addAttribute("professeur", professeur);
        model.addAttribute("success", "Modification avec succès");
        model.addAttribute("style", "bg-info text-white text-center mt-3 mb-3 pt-2 pb-2 font-weight-bold font-italic rounded");
        System.out.println(model.getAttribute("success") + " cote UPDATE");

        return "professeur/detail";
    }

    // Get One Professor By his ID - Details
    @GetMapping("/id/{id}")
    public String detail(@PathVariable("id") int id, Model model, RedirectAttributes attributes){
        model.addAttribute("professeur", professeurService.getProfesseur(id));

        System.out.println(attributes.getFlashAttributes().get("success") + " cote AFFICHAGE");
        model.addAttribute("success", attributes.getAttribute("success"));
        //model.addAttribute("style", model.getAttribute("style"));

        return "/professeur/detail";
    }

    // Get All Professors
    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("professeurs", professeurService.getProfesseurs());
        return "professeur/list";
    }

    // Get Professors By Firstname
    @GetMapping("/prenom/{prenom}")
    public String getProfesseurByFirstname(@PathVariable("prenom") String firstname, Model model){
        model.addAttribute("professeurs", professeurService.getProfesseurByFirstname(firstname));
        return "professeur/list";
    }

    // Get Professors By Lastname
    @GetMapping("/nom/{nom}")
    public String getProfesseurByLastname(@PathVariable("nom") String lastname, Model model){
        model.addAttribute("professeurs", professeurService.getProfesseurByLastname(lastname));
        return "professeur/list";
    }

    // Get One Professor By his Email
    @GetMapping("/email/{email}")
    public String getProfesseurByEmail(@PathVariable("email") String email, Model model){
        model.addAttribute("professeur", professeurService.getProfesseurByEmail(email));
        return "/professeur/detail";
    }

    // Get Professors By First and Last Name
    @GetMapping("/nomcomplet/{prenom}/{nom}")
    public String getProfesseurByPrenomAndNom(@PathVariable("prenom") String firstname, @PathVariable("nom") String lastname, Model model){
        model.addAttribute("professeurs", professeurService.getProfesseurByPrenomAndNom(firstname, lastname));
        return "professeur/list";
    }

    // Remove A Professor By his ID
    @GetMapping("delete/{id}")
    public String deleteProfesseur(@PathVariable("id") int id){
        professeurService.deleteProfesseur(id);
        return "redirect:/professeur/list";
    }
}
