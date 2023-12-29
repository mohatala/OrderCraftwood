package craft.DTO;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import craft.model.Article;
import craft.model.Client;

public class CmdArtDTO {
	private int id_commande;
	private Client client;
	private String etat;
	private Date created_at;
	private Article art;
    private int qty;
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Article getArt() {
		return art;
	}
	public void setArt(Article art) {
		this.art = art;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
    
}
