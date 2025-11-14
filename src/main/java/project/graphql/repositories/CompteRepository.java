package project.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.graphql.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    @Query("SELECT COALESCE(SUM(c.solde), 0) FROM Compte c")
    double sumSoldes();
}
