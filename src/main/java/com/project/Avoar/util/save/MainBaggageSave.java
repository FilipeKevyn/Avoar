package com.project.Avoar.util.save;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.BaggageDAOImpl;
import com.project.Avoar.entities.Baggage;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainBaggageSave {
    public static void main(String[] args) {
        Baggage baggage = new Baggage(
                null,
                "Despachada",
                23.5
        );

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            BaggageDAOImpl repository = new BaggageDAOImpl(Baggage.class, emf);
            repository.save(baggage);
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}
