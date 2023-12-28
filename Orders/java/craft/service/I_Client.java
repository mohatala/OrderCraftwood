package craft.service;

import java.util.ArrayList;
import java.util.List;

import craft.model.Client;

public interface I_Client {
	
	public Client ajouterClient(Client c);
	public Client modifierClient(Client c);
	public Client afficherClientAvecId(int id);
	public List<Client> afficherClients();
	public boolean supprimeClient(int id);

}
