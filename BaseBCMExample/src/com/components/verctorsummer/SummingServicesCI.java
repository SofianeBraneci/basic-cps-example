package com.components.verctorsummer;

import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface SummingServicesCI extends RequiredCI{
	double sum(double a, double b) throws Exception;

}
