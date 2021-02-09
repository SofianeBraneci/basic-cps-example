package com.components;

import com.components.calculator.Calculator;
import com.components.verctorsummer.VectorSummer;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.cvm.AbstractCVM;

public class CVM extends AbstractCVM {

	public CVM() throws Exception {
		
	}

	@Override
	public void deploy() throws Exception {
		AbstractComponent.createComponent(Calculator.class.getCanonicalName(), new Object[]{});
		String vectorURI = AbstractComponent.createComponent(VectorSummer.class.getCanonicalName(), new Object[]{});
		this.doPortConnection(vectorURI, VectorSummer.SSOP_URI, Calculator.CSIP_URI, Connector.class.getCanonicalName());
	}

	public static void main(String[] args) throws Exception {
		CVM c = new CVM();
		c.startStandardLifeCycle(5000L);
		System.exit(0);
	}

}
