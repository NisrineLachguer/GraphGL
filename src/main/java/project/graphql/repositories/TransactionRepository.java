package project.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.graphql.entities.Compte;
import project.graphql.entities.Transaction;
import project.graphql.entities.TypeTransaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCompte(Compte compte);

    @Query("SELECT COALESCE(SUM(t.montant), 0) FROM Transaction t WHERE t.type = :type")
    double sumByType(@Param("type") TypeTransaction type);
}
