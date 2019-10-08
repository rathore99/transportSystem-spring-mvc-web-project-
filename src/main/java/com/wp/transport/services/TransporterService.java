package com.wp.transport.services;

import java.util.List;

import com.wp.transport.entities.Transporter;

public interface TransporterService {

	public boolean addTransporter(Transporter transporter);

	public Transporter deleteTransporter(Transporter transporter);

	public void updateTransporter(Transporter transporter);

	public Transporter searchTransporter(String email);

	public List<Transporter> show();
	
	public Transporter getTransporter(String email, String password);
}
