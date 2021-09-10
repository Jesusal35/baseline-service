package com.tis.mx.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class InitialInvestmentDto {
  
  public InitialInvestmentDto() {
    // TODO Auto-generated constructor stub
  }

  private Double initialInvestment; //inversion inicial (debe ser mayor de mil)
  private Double yearlyInput; //aportacion anual (Se debe de validar el valor si no se tiene se considera cero)
  private Integer yearlyInputIncrement; //porcentage incremento de aportacion anual
  private Float investmentYield  ; //rendimiento de inversion
  private Integer investmentYears; // años de inversion
  
  

}
