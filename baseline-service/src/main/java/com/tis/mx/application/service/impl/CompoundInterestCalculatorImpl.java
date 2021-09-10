package com.tis.mx.application.service.impl;


import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import java.util.List;


public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator{

  @Override
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestment) {
    
    for(int i=1; i<initialInvestment.getInvestmentYears();i++ ) {
      
      if(i==1) {
        Integer year = i;
        Double initialInvest = initialInvestment.getInitialInvestment();
        Double yearlyInput = initialInvestment.getYearlyInput();
        Double investmentYield = ((initialInvestment.getInitialInvestment()+
               initialInvestment.getYearlyInput())*
              (initialInvestment.getInvestmentYield().doubleValue()/100));
        Double finalBalance = initialInvest+yearlyInput+investmentYield;
        
      }else {
        Integer year = i;      
        Double initialInvest =initialInvestment.getInitialInvestment() ;//DEberia de ser el finalBalance
        Double yearlyInput = (initialInvestment.getYearlyInput())*
                  (1+(initialInvestment.getYearlyInputIncrement()/100));
        Double investmentYield = ((initialInvestment.getInitialInvestment()+
               initialInvestment.getYearlyInput())*
              (initialInvestment.getInvestmentYield().doubleValue()/100));
        
        
      }
      
      
    }
    Double yearlyInput = initialInvestment.getYearlyInput();
    yearlyInput = yearlyInput == null ? 0.0 : yearlyInput;
    initialInvestment.setYearlyInput(yearlyInput);
    
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean validateInput(InitialInvestmentDto initialInvestment) {
    
    
    boolean cumple = true;
    
    cumple = cumple && (initialInvestment.getInitialInvestment()>=1000);
    cumple = cumple && (initialInvestment.getYearlyInput() >= 0.0);
    cumple = cumple && (initialInvestment.getYearlyInputIncrement() >= 0.0);
    cumple = cumple && (initialInvestment.getInvestmentYears() >0);
    cumple = cumple && (initialInvestment.getInvestmentYield() >0);
    
    //if initial investment > 1000 return true 
    return cumple;
  }
  
  private void setDefaults(InitialInvestmentDto initialInvestment) {
    Double yearlyInput = initialInvestment.getYearlyInput();
    yearlyInput = yearlyInput == null ? 0.0 : yearlyInput;
    initialInvestment.setYearlyInput(yearlyInput);
    
    Integer yearlyInputIncrement = initialInvestment.getYearlyInputIncrement();
    yearlyInputIncrement = yearlyInputIncrement == null ? 0 : yearlyInputIncrement;
    initialInvestment.setYearlyInputIncrement(yearlyInputIncrement);
  }

}
