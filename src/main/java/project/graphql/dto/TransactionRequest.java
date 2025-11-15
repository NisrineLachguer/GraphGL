package project.graphql.dto;

import lombok.Data;
import project.graphql.entities.TypeTransaction;

import java.util.Date;

@Data
public class TransactionRequest {
    private Long compteId;
    private double montant;
    private Date date;
    private TypeTransaction type;
}
