package com.groupeisi;

import com.groupeisi.dao.IProfesseurRepository;
import com.groupeisi.entities.ProfesseurEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class PointageApplication {
	@Autowired
	private IProfesseurRepository repository;
	@PostConstruct
	public void initUsers(){
		List<ProfesseurEntity> users = Stream.of(
			new ProfesseurEntity(101, "MBOW", "Fallou", "", "mbow@gmail.com", "passer123", 1, null),
			new ProfesseurEntity(102, "DIOP", "Moustapha", "", "diop@gmail.com", "passer123", 1, null),
			new ProfesseurEntity(103, "SECK", "Diama", "", "seck@gmail.com", "passer123", 1, null),
			new ProfesseurEntity(104, "TALL", "Madicke", "", "tall@gmail.com", "passer123", 1, null)
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(PointageApplication.class, args);
	}

}
