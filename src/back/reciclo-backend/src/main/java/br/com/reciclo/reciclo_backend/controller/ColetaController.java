package br.com.reciclo.reciclo_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@RestController
public class ColetaController {
    @PersistenceUnit
    EntityManagerFactory factory;

    @PostMapping("/api/v1/coletas")
    public @ResponseBody Coleta cadastrarColeta(@RequestParam,){
        EntityManager manager = factory.createEntityManager();
        Coleta novColeta = new Coleta();

        manager.getTransaction().begin();
        manager.persist(novColeta);
        manager.getTransaction().commit();

        return novColeta; // OU DTO
    }

    @GetMapping("/api/v1/coletas/{id}")
    public @ResponseBody Coleta buscarColeta(@PathVariable int id){
        EntityManager manager = factory.createEntityManager();
        Coleta coleta = manager.find(Coleta.class, id);
    }

}
