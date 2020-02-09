package com.cva_risk.database_access.repositories;

import com.cva_risk.model.InputTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InputTransactionRepository extends JpaRepository<InputTransaction, Integer> {

    @Query("SELECT t.residualMaturity FROM InputTransaction t WHERE t.id = :id")
    Integer getResidualMaturityOfTransactionWithId(@Param("id") int id);

    @Query("SELECT DISTINCT t.nettingSetId FROM InputTransaction t WHERE t.nettingSetId IS NOT NULL")
    List<Integer> findIdsOfNormalNettingSets();

    @Query("SELECT t.currentMarketValue FROM InputTransaction t WHERE t.nettingSetId = :nettingSetId")
    List<Double> getCurrentMarketValuesOfTransactionsInNS(@Param("nettingSetId") int nettingSetId);

    @Query("SELECT t.nominalValue, t.residualMaturity FROM InputTransaction t WHERE t.nettingSetId = :nettingSetId")
    List<Object[]> getNominalValueAndResidualMaturityOfTransactionsInNS(@Param("nettingSetId") int nettingSetId);

    @Query("SELECT t.nominalValue FROM InputTransaction t WHERE t.id = :id")
    Double getNominalValueOfTransactionWithId(@Param("id") int id);

    @Query("SELECT t.residualMaturity, t.nominalValue FROM InputTransaction t WHERE t.referencedCounterpartyId = :referencedCounterpartyId")
    List<Object[]> findResMaturityAndNominalValueOfSingleCVAHedgesForCounterparty(@Param("referencedCounterpartyId") Integer referencedCounterpartyId);

    @Query("SELECT t.residualMaturity, t.nominalValue FROM InputTransaction t WHERE t.cvaHedge = TRUE AND t.referencedCounterpartyId IS NULL")
    List<Object[]> findResMaturityAndNominalValueOfIndexCVAHedges();


}


