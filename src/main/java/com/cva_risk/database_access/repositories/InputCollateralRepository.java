package com.cva_risk.database_access.repositories;

import com.cva_risk.model.InputCollateral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InputCollateralRepository extends JpaRepository<InputCollateral, Integer> {

}
