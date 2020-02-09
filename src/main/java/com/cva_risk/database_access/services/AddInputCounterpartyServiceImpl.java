package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCounterpartyRepository;
import com.cva_risk.model.InputCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddInputCounterpartyServiceImpl implements AddInputCounterpartyService {

    @Autowired
    private InputCounterpartyRepository inputCounterpartyRepository;

    @Transactional
    public void saveInputCounterparty(InputCounterparty inputCounterpartyDAO){

        InputCounterparty inputCounterparty = new InputCounterparty();

        inputCounterparty.setArticle128(inputCounterpartyDAO.getArticle128());
        inputCounterparty.setCreditQualityStepBasedOnIRBA(inputCounterpartyDAO.getCreditQualityStepBasedOnIRBA());
        inputCounterparty.setId(inputCounterpartyDAO.getId());
        inputCounterparty.setName(inputCounterpartyDAO.getName());
        inputCounterparty.setRatingCRAG(inputCounterpartyDAO.getRatingCRAG());
        inputCounterparty.setRatingDBRS(inputCounterpartyDAO.getRatingDBRS());
        inputCounterparty.setRatingDBRSShortTerm(inputCounterpartyDAO.getRatingDBRSShortTerm());
        inputCounterparty.setRatingEHRG(inputCounterpartyDAO.getRatingEHRG());
        inputCounterparty.setRatingFitch(inputCounterpartyDAO.getRatingFitch());
        inputCounterparty.setRatingFitchCIU(inputCounterpartyDAO.getRatingFitchCIU());
        inputCounterparty.setRatingFitchShortTerm(inputCounterpartyDAO.getRatingFitchShortTerm());
        inputCounterparty.setRatingJCRA(inputCounterpartyDAO.getRatingJCRA());
        inputCounterparty.setRatingJCRAShortTerm(inputCounterpartyDAO.getRatingJCRAShortTerm());
        inputCounterparty.setRatingMoodys(inputCounterpartyDAO.getRatingMoodys());
        inputCounterparty.setRatingMoodysCIU(inputCounterpartyDAO.getRatingMoodysCIU());
        inputCounterparty.setRatingMoodysShortTerm(inputCounterpartyDAO.getRatingMoodysShortTerm());
        inputCounterparty.setRatingSandP(inputCounterpartyDAO.getRatingSandP());
        inputCounterparty.setRatingSandPFundCreditQualityRatingsCIU(inputCounterpartyDAO.getRatingSandPFundCreditQualityRatingsCIU());
        inputCounterparty.setRatingSandPPrincipalStabilityFundRatingsCIU(inputCounterpartyDAO.getRatingSandPPrincipalStabilityFundRatingsCIU());
        inputCounterparty.setRatingSandPShortTerm(inputCounterpartyDAO.getRatingSandPShortTerm());
        //inputCounterparty.setIntermediateResultsCounterparty(inputCounterpartyDAO.getIntermediateResultsCounterparty());
        //inputCounterparty.setInputTransactionList(inputCounterpartyDAO.getInputTransactionList());

        inputCounterpartyRepository.save(inputCounterparty);

    }
}
