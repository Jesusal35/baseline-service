package com.tis.mx.application.service.impl;


import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator{

  @Override
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestment) {
    
    InvestmentYieldDto investmentYield = new InvestmentYieldDto();
    List<InvestmentYieldDto> tableYield = new ArrayList<>();
    
    for(int i=1; i<=initialInvestment.getInvestmentYears();i++ ) {
      Integer year = i;
      if(i==1) {
        //Double initialInvest = initialInvestment.getInitialInvestment(); 
        //Double yearlyInput = initialInvestment.getYearlyInput();
        Double investmentYieldr = ((initialInvestment.getInitialInvestment()+
               initialInvestment.getYearlyInput())*
              (initialInvestment.getInvestmentYield().doubleValue()/100));
        Double finalBalance = initialInvestment.getInitialInvestment()+
            initialInvestment.getYearlyInput()+investmentYieldr;
        investmentYield.setFinalBalance(finalBalance);
        investmentYield.setInitialInvestment(initialInvestment.getInitialInvestment());
        investmentYield.setYearlyInput(initialInvestment.getYearlyInput());
        tableYield.add(investmentYield);
      }else {
              
        Double initialInvest = finalBalance;//DEberia de ser el finalBalance
        Double yearlyInput = (initialInvestment.getYearlyInput())*
                  (1+(initialInvestment.getYearlyInputIncrement()/100));
        investmentYield.setInitialInvestment(initialInvestment.getInitialInvestment());
        Double investmentYieldr = ((initialInvestment.getInitialInvestment()+
               initialInvestment.getYearlyInput())*
              (initialInvestment.getInvestmentYield().doubleValue()/100));
        investmentYield.setInvestmentYield(investmentYieldr);
        Double finalBalance = initialInvest+yearlyInput+investmentYieldr;
        investmentYield.setFinalBalance(finalBalance);
        tableYield.add(investmentYield);
        
        
      }
      
      
    }
    Double yearlyInput = initialInvestment.getYearlyInput();
    yearlyInput = yearlyInput == null ? 0.0 : yearlyInput;
    initialInvestment.setYearlyInput(yearlyInput);
    
    // TODO Auto-generated method stub
    return null;
  }

  
  /*private InvestmentYieldDto calculateYield(InitialInvestmentDto initialInvestment, 
      Optional<InvestmentYieldDto> lastInvestmentYield) {
    
    InvestmentYieldDto investmentYield = new InvestmentYieldDto();
    
    if (lastInvestmentYield.isPresent()) {      
      InvestmentYieldDto lastResult = lastInvestmentYield.get();
      investmentYield.setInvestmentYear(lastResult.getInvestmentYear() + 1);
      investmentYield.setInitialInvestment(lastResult.getFinalBalance());
      investmentYield.setYearlyInput(
          lastResult.getYearlyInput() 
          * (1 + ((float) initialInvestment.getYearlyInputIncrement() / 100f)));
    } else {
      investmentYield.setInvestmentYear(1);
      investmentYield.setInitialInvestment(initialInvestment.getInitialInvestment());
      investmentYield.setYearlyInput(initialInvestment.getYearlyInput());
    }
    
    Float revenue = (investmentYield.getInitialInvestment() + investmentYield.getYearlyInput())
        * (initialInvestment.getInvestmentYield() / 100f); 
    investmentYield.setInvestmentYield(revenue);
    
    Float finalBalance = investmentYield.getInitialInvestment() 
        + investmentYield.getYearlyInput()
        + investmentYield.getInvestmentYield();
    investmentYield.setFinalBalance(finalBalance);
    
    return investmentYield;
  }*/
  
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
