package com.wp.transport.dao;

import java.util.List;

import com.wp.transport.entities.Transporter;

public interface TransporterDAO {
	public boolean addTransporter(Transporter transporter);

	public Transporter deleteTransporter(Transporter transporter);

	public Transporter searchTransporter(String email);

	public List<Transporter> getTransporterList();

	public void updateTransporter(Transporter transporter);

	public List<Transporter> getTransporter(String email, String password);

	public Transporter getTransporterById(int id);

	public List<Transporter> getListByStatus(boolean status);
}
