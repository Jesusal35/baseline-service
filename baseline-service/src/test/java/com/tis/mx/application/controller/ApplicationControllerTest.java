package com.tis.mx.application.controller;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import com.tis.mx.application.service.impl.CompoundInterestCalculatorImpl;

public class ApplicationControllerTest {
  private AplicationController controller;
  private InitialInvestmentDto initialInvestment;
  private CompoundInterestCalculator calculator;
  
  @Before
  public void createValuesBeforeToTest() {
    //crea una calculadora
    this.calculator = new CompoundInterestCalculatorImpl();
    this.controller = new AplicationController(this.calculator);
    this.initialInvestment = new InitialInvestmentDto();
    
    //Crear los valores iniciales de la inversion
    
    
    this.initialInvestment.setInitialInvestment(5000.00);
    this.initialInvestment.setYearlyInput(300.00);
    this.initialInvestment.setYearlyInputIncrement(1);
    this.initialInvestment.setInvestmentYears(5);
    this.initialInvestment.setInvestmentYield(21f);
    
    //this.controller = new AplicationController(this.calculator);
  }
  @Test
  public void ShouldGenerateTableYield() {
    List<InvestmentYieldDto> tableYield =  controller.createTableYield(initialInvestment);
    assertEquals(5,tableYield.size());
    
    
  }

}
