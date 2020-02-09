package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsCounterpartyRepository;
import com.cva_risk.model.IntermediateResultsCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddIntermediateResultsCounterpartyServiceImpl implements AddIntermediateResultsCounterpartyService {

    @Autowired
    private IntermediateResultsCounterpartyRepository intermediateResultsCounterpartyRepository;

    @Transactional
    public void saveIntermediateResultsCounterparty(IntermediateResultsCounterparty intermediateResultsCounterpartyDAO){

        IntermediateResultsCounterparty intermediateResultsCounterparty = new IntermediateResultsCounterparty();

        intermediateResultsCounterparty.setId(intermediateResultsCounterpartyDAO.getId());
        intermediateResultsCounterparty.setName(intermediateResultsCounterpartyDAO.getName());
        intermediateResultsCounterparty.setWeight(intermediateResultsCounterpartyDAO.getWeight());
        intermediateResultsCounterparty.setWeightRatingCRAG(intermediateResultsCounterpartyDAO.getWeightRatingCRAG());
        intermediateResultsCounterparty.setWeightRatingDBRS(intermediateResultsCounterpartyDAO.getWeightRatingDBRS());
        intermediateResultsCounterparty.setWeightRatingDBRSShortTerm(intermediateResultsCounterpartyDAO.getWeightRatingDBRSShortTerm());
        intermediateResultsCounterparty.setWeightRatingEHRG(intermediateResultsCounterpartyDAO.getWeightRatingEHRG());
        intermediateResultsCounterparty.setWeightRatingFitch(intermediateResultsCounterpartyDAO.getWeightRatingFitch());
        intermediateResultsCounterparty.setWeightRatingFitchCIU(intermediateResultsCounterpartyDAO.getWeightRatingFitchCIU());
        intermediateResultsCounterparty.setWeightRatingFitchShortTerm(intermediateResultsCounterpartyDAO.getWeightRatingFitchShortTerm());
        intermediateResultsCounterparty.setWeightRatingJCRA(intermediateResultsCounterpartyDAO.getWeightRatingJCRA());
        intermediateResultsCounterparty.setWeightRatingJCRAShortTerm(intermediateResultsCounterpartyDAO.getWeightRatingJCRAShortTerm());
        intermediateResultsCounterparty.setWeightRatingMoodys(intermediateResultsCounterpartyDAO.getWeightRatingMoodys());
        intermediateResultsCounterparty.setWeightRatingMoodysCIU(intermediateResultsCounterpartyDAO.getWeightRatingMoodysCIU());
        intermediateResultsCounterparty.setWeightRatingMoodysShortTerm(intermediateResultsCounterpartyDAO.getWeightRatingMoodysShortTerm());
        intermediateResultsCounterparty.setWeightRatingSandP(intermediateResultsCounterpartyDAO.getWeightRatingSandP());
        intermediateResultsCounterparty.setWeightRatingSandPFundCreditQualityRatingsCIU(intermediateResultsCounterpartyDAO.getWeightRatingSandPFundCreditQualityRatingsCIU());
        intermediateResultsCounterparty.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(intermediateResultsCounterpartyDAO.getWeightRatingSandPPrincipalStabilityFundRatingsCIU());
        intermediateResultsCounterparty.setWeightRatingSandPShortTerm(intermediateResultsCounterpartyDAO.getWeightRatingSandPShortTerm());
        intermediateResultsCounterparty.setInputCounterparty(intermediateResultsCounterpartyDAO.getInputCounterparty());
        intermediateResultsCounterparty.setIntermediateResultsTransactionList(intermediateResultsCounterpartyDAO.getIntermediateResultsTransactionList());
        intermediateResultsCounterparty.setIntermediateResultsNettingSetList(intermediateResultsCounterpartyDAO.getIntermediateResultsNettingSetList());

        intermediateResultsCounterpartyRepository.save(intermediateResultsCounterparty);

    }

}
