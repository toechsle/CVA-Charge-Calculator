package com.cva_risk.database_access.repositories;

import com.cva_risk.model.IntermediateResultsCounterparty;
import com.cva_risk.model.IntermediateResultsTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IntermediateResultsTransactionRepository extends JpaRepository<IntermediateResultsTransaction, Integer> {

    @Query("SELECT DISTINCT t2 FROM IntermediateResultsTransaction t2 JOIN t2.inputTransaction t1 WHERE t1.nettingSetId IS NULL AND t1.optionWriterPosition = FALSE")
    List<IntermediateResultsTransaction> findMinimalNettingSets();

    @Query("SELECT DISTINCT t2 FROM IntermediateResultsTransaction t2 JOIN t2.inputTransaction t1 WHERE t1.nettingSetId = :nettingSetId")
    List<IntermediateResultsTransaction> findTransactionsInNSWithId(@Param("nettingSetId") int nettingSetId);

    @Query("SELECT DISTINCT t2.intermediateResultsCounterparty FROM IntermediateResultsTransaction t2 JOIN t2.inputTransaction t1 WHERE t1.nettingSetId = :nettingSetId")
    IntermediateResultsCounterparty findCounterpartyForNSWithId(@Param("nettingSetId") Integer nettingSetId);

}

