package com.components.verctorsummer;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@RequiredInterfaces(required = {SummingServicesCI.class})
public class VectorSummer extends AbstractComponent{
	protected SummingServicesOutboundPort ssop;
	public static final String SSOP_URI = "ssop-uri"; 
	protected VectorSummer() throws Exception {
		super(1, 0);
		this.ssop = new SummingServicesOutboundPort(SSOP_URI, this);
		this.ssop.publishPort();
		this.toggleLogging();
		this.toggleTracing();
	}

	@Override
	public synchronized void execute() throws Exception {
		double [] values = {1.0, 2.0, 3.0, 4.0, 5.0};
		double sum = 0;
		for(int i = 0; i < values.length; i++) {
			sum = this.ssop.sum(sum, values[i]);
		}
		this.logMessage("Sum = " + sum);

	}
	@Override
	public synchronized void finalise() throws Exception {
		this.doPortDisconnection(SSOP_URI);
	}
	
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.ssop.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
	}

}
