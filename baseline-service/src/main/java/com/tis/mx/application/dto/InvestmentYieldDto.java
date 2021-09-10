package com.tis.mx.application.dto;

import com.tis.mx.application.dto.InitialInvestmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor


public class InvestmentYieldDto{
  
  private Integer investmentYear ;//año 
  private Double initialInvestment;//saldo inicial
  private Double yearlyInput;//aportacion 
  //private double Calis = (investmentYield/100);
  private Double investmentYield = (initialInvestment + yearlyInput);//Rendimiento
  private Double finalBalance = initialInvestment + investmentYield +yearlyInput;//balance final

}
