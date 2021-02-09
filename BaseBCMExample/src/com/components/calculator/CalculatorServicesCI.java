package com.components.calculator;

import fr.sorbonne_u.components.interfaces.OfferedCI;
// Represents all the services offered by the component 
public interface CalculatorServicesCI extends OfferedCI{
		
	double add(double x, double y) throws Exception;
	double subtract(double x , double y) throws Exception;
}
