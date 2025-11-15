package project.graphql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.graphql.entities.Compte;
import project.graphql.entities.TypeCompte;
import project.graphql.repositories.CompteRepository;

import java.util.Date;

@SpringBootApplication
public class GraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CompteRepository compteRepository) {
        return args -> {
            // Création de quelques comptes de test
            Compte compte1 = new Compte();
            compte1.setSolde(15000.0);
            compte1.setDateCreation(new Date());
            compte1.setType(TypeCompte.COURANT);

            Compte compte2 = new Compte();
            compte2.setSolde(75000.0);
            compte2.setDateCreation(new Date());
            compte2.setType(TypeCompte.EPARGNE);

            Compte compte3 = new Compte();
            compte3.setSolde(25000.0);
            compte3.setDateCreation(new Date());
            compte3.setType(TypeCompte.COURANT);

            // Sauvegarde des comptes
            compteRepository.save(compte1);
            compteRepository.save(compte2);
            compteRepository.save(compte3);

            // Affichage dans les logs
            System.out.println("=== COMPTES CRÉÉS AVEC SUCCÈS ===");
            System.out.println("Compte 1: " + compte1.getSolde() + " MAD - " + compte1.getType());
            System.out.println("Compte 2: " + compte2.getSolde() + " MAD - " + compte2.getType());
            System.out.println("Compte 3: " + compte3.getSolde() + " MAD - " + compte3.getType());
            System.out.println("Total des comptes: " + compteRepository.count());
            System.out.println("Somme totale des soldes: " + compteRepository.sumSoldes() + " MAD");
            System.out.println("==================================");
        };
    }
}