package craft.service;

import java.util.ArrayList;
import java.util.List;

import craft.model.Commande;

public interface I_Commande {
	
	public Commande ajouterCommande(Commande c,String listart);
	public Commande afficherCommandeAvecId(int id);
	public List afficherCommandes();
	public ArrayList<String> afficherInfosCommande(int id);
	public Commande modifieretat(int id,String etat) ;
	public boolean supprimeCommandes(int id);


}
