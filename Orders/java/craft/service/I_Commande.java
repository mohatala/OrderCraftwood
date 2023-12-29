package craft.service;

import java.util.ArrayList;
import java.util.List;

import craft.DTO.CmdArtDTO;
import craft.model.Commande;

public interface I_Commande {
	
	public Commande ajouterCommande(Commande c,String listart);
	public Commande afficherCommandeAvecId(int id);
	public List afficherCommandes();
	public List<CmdArtDTO> afficherInfosCommande(int id);
	public Commande modifieretat(int id,String etat) ;
	public boolean supprimeCommandes(int id);


}
