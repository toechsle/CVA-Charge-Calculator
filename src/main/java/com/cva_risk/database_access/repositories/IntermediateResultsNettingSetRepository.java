package com.cva_risk.database_access.repositories;

import com.cva_risk.model.IntermediateResultsCounterparty;
import com.cva_risk.model.IntermediateResultsNettingSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IntermediateResultsNettingSetRepository extends JpaRepository<IntermediateResultsNettingSet, Integer> {

    @Query("SELECT n.residualMaturity, n.nominalValue FROM IntermediateResultsNettingSet n WHERE n.intermediateResultsCounterparty = :intermediateResultsCounterparty")
    List<Object[]> getResidualMaturityAndNominalValueOfNettingSetsWithCounterparty(@Param("intermediateResultsCounterparty") IntermediateResultsCounterparty intermediateResultsCounterparty);

    @Query("SELECT n.exposureValueAfterCollateral FROM IntermediateResultsNettingSet n WHERE n.intermediateResultsCounterparty = :intermediateResultsCounterparty")
    List<Double> getEADsAfterCollateralForCounterparty(@Param("intermediateResultsCounterparty") IntermediateResultsCounterparty intermediateResultsCounterparty);

    @Query("SELECT n.effectiveResidualMaturity, n.discountedExposureValueAfterCollateral FROM IntermediateResultsNettingSet n WHERE n.intermediateResultsCounterparty = :intermediateResultsCounterparty")
    List<Object[]> getEffectiveResidualMaturityAndDiscountedEADAfterCollateralOfNettingSetsWithCounterparty(@Param("intermediateResultsCounterparty") IntermediateResultsCounterparty intermediateResultsCounterparty);

}


