package com.client.doranco.v2;

public class Main {

	public static void main(String[] args) {
		CalculatorService calculatorService=new CalculatorService();
		Calculator calculator=calculatorService.getCalculatorPort();
		int somme=calculator.sum(12, 13);
		System.out.println("La somme = "+somme);
	}

}
