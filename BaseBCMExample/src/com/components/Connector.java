package com.components;

import com.components.calculator.CalculatorServicesCI;
import com.components.verctorsummer.SummingServicesCI;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class Connector extends AbstractConnector implements SummingServicesCI {

	public Connector() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double sum(double a, double b) throws Exception {
		// TODO Auto-generated method stub
		return ((CalculatorServicesCI)this.offering).add(a, b);
	}

}
