package com.components.calculator;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {CalculatorServicesCI.class})
public class Calculator extends AbstractComponent {

	protected CalculatorServicesInboudPort csip;
	public static final String CSIP_URI = "csip-uri";
	protected Calculator() {
		super(1, 0);
		try {
			csip = new CalculatorServicesInboudPort(CSIP_URI, this);
			csip.publishPort();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.csip.unpublishPort();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ComponentShutdownException(e);
		}
	}
	
	public double addition(double x, double y ) {
		return x + y;
	}

	public double subtration(double x, double y ) {
		return x - y;
	}
}
