package com.tis.mx.application.controller;

import com.tis.mx.application.service.CompoundInterestCalculator;
import java.util.List;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;

public class AplicationController {
  
  private CompoundInterestCalculator calculator;
  
  public AplicationController(CompoundInterestCalculator calculator) {
    this.calculator = calculator;
  }
  
  public List<InvestmentYieldDto> createTableYield(InitialInvestmentDto initialInvestment){
    if(calculator.validateInput(initialInvestment)) {
      return calculator.createRevenueGrid(initialInvestment);
    }
      throw new CalculatorInputException("El calculo no puede ser ejecutado");
  }
  
  
  
  /*public void main(String args) {
    
    initialInvestment = 5000; //inversion inicial (debe ser mayor de mil)
    yearlyInput = 3000; //aportacion anual (Se debe de validar el valor si no se tiene se considera cero)
    yearlyInputIncrement = 1; //porcentage incremento de aportacion anual
    investmentYield = 21 ; //rendimiento de inversion
    investmentYears = 5; // años de inversion
    
    For(int i=1;i<=investmentYears;i++){
      System.out.println("| Año: "+i
                        +"| Saldo inicial: "+initialInvestment
                        +"| Aportacion: " + yearlyInputY
                        +"| Rendimiento: " + investmentYield
                        +"| Saldo final: " + finalBalance);
    }
    //Ganancia= Monto del ultimo año -(suma de aportaciones "Talvez irlos sumando o metiendo a un arreglo"
    //          - inversion inicial
    System.out.println("Monto final: "+ finalBalance+"/n"
                        + "Ganancia por inversion: "+(Ganancia ));
    
  }*/

}
