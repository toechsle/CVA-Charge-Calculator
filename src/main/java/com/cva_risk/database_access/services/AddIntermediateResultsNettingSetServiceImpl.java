package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsNettingSetRepository;
import com.cva_risk.model.IntermediateResultsNettingSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddIntermediateResultsNettingSetServiceImpl implements AddIntermediateResultsNettingSetService {

    @Autowired
    private IntermediateResultsNettingSetRepository intermediateResultsNettingSetRepository;

    @Transactional
    public void saveIntermediateResultsNettingSet(IntermediateResultsNettingSet intermediateResultsNettingSetDAO) {

        IntermediateResultsNettingSet intermediateResultsNettingSet = new IntermediateResultsNettingSet();

        intermediateResultsNettingSet.setId(intermediateResultsNettingSetDAO.getId());
        intermediateResultsNettingSet.setIntermediateResultsCounterparty(intermediateResultsNettingSetDAO.getIntermediateResultsCounterparty());
        intermediateResultsNettingSet.setDiscountedExposureValueAfterCollateral(intermediateResultsNettingSetDAO.getDiscountedExposureValueAfterCollateral());
        intermediateResultsNettingSet.setExposureValueAfterCollateral(intermediateResultsNettingSetDAO.getExposureValueAfterCollateral());
        intermediateResultsNettingSet.setExposureValueBeforeCollateral(intermediateResultsNettingSetDAO.getExposureValueBeforeCollateral());
        intermediateResultsNettingSet.setEffectiveResidualMaturity(intermediateResultsNettingSetDAO.getEffectiveResidualMaturity());
        intermediateResultsNettingSet.setResidualMaturity(intermediateResultsNettingSetDAO.getResidualMaturity());
        intermediateResultsNettingSet.setNominalValue(intermediateResultsNettingSetDAO.getNominalValue());
        intermediateResultsNettingSet.setNetReplacementCost(intermediateResultsNettingSetDAO.getNetReplacementCost());
        intermediateResultsNettingSet.setGrossReplacementCost(intermediateResultsNettingSetDAO.getGrossReplacementCost());
        intermediateResultsNettingSet.setNetToGrossRatio(intermediateResultsNettingSetDAO.getNetToGrossRatio());
        intermediateResultsNettingSet.setPceGross(intermediateResultsNettingSetDAO.getPceGross());
        intermediateResultsNettingSet.setPceRed(intermediateResultsNettingSetDAO.getPceRed());

        intermediateResultsNettingSetRepository.save(intermediateResultsNettingSet);

    }

}
