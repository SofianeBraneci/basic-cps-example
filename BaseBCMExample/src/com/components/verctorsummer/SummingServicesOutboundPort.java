package com.components.verctorsummer;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class SummingServicesOutboundPort extends AbstractOutboundPort implements SummingServicesCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SummingServicesOutboundPort( ComponentI owner)
			throws Exception {
		super(SummingServicesCI.class, owner);
	}

	public SummingServicesOutboundPort(String uri,ComponentI owner)
			throws Exception {
		super(uri, SummingServicesCI.class, owner);
	}

	@Override
	public double sum(double a, double b) throws Exception {
		// TODO Auto-generated method stub
		return ((SummingServicesCI )this.getConnector()).sum(a, b);
	}

}
