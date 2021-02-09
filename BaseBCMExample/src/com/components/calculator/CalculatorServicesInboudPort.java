package com.components.calculator;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class CalculatorServicesInboudPort extends AbstractInboundPort implements CalculatorServicesCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculatorServicesInboudPort( ComponentI owner)
			throws Exception {
		super(CalculatorServicesCI.class, owner);
		
	}
	

	public CalculatorServicesInboudPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, CalculatorServicesCI.class, owner);
		assert owner instanceof Calculator;
	}
	
	@Override
	public double add(double x, double y) throws Exception {
		return this.getOwner().handleRequest(c -> ((Calculator) c).addition(x, y));
	}

	@Override
	public double subtract(double x, double y) throws Exception {
		return this.getOwner().handleRequest(c -> ((Calculator) c).subtration(x, y));

	}

}
