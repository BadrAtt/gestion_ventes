package com.mql.gestionventes.Services;

import java.util.List;

import com.mql.gestionventes.Entity.Client;
import com.mql.gestionventes.Factory.DaoFactory;

public class ClientService {
	
	public Client getClientByCode(int code) {
		return DaoFactory.getClientDao().find(code);
	}
	
	public boolean createClient(Client client) {
		return DaoFactory.getClientDao().create(client);
	}
	
	public boolean updateClient(Client client) {
		return DaoFactory.getClientDao().update(client);
	}
	
	public boolean deleteClient(Client client) {
		return DaoFactory.getClientDao().delete(client);
	}
	
	public List<Client> getAllClients(){
		return DaoFactory.getClientDao().getAll();
	}
	
	public int getTotalClient(){
		return DaoFactory.getClientDao().getTotalClient();
	}
}
