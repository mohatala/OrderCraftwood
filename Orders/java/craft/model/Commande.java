package craft.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_commande;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	private String etat;
	private Date created_at;
	private Date updated_at;
	
    
    public Commande() {}
	public Commande(CommandeBuilder builder) {
		this.id_commande= builder.id_commande;
		this.client = builder.client;
		this.etat = builder.etat;
		this.created_at=builder.created_at;
		this.updated_at=builder.updated_at;
	}

	public int getId_commande() {
		return id_commande;
	}

	public Client getclient() {
		return client;
	}

	public String getEtat() {
		return etat;
	}

	public Date getcreated_at() {
		return created_at;
	}

	public Date getupdated_at() {
		return updated_at;
	}

	@Override
	public String toString() {
		return "[id_commande=" + id_commande + ", client=" + client + ", etat=" + etat
				+ ", created_at=" + created_at + "]";
	}
	
	public static class CommandeBuilder{
		private int id_commande;
		private Client client;
		private String etat;
		private Date created_at;
		private Date updated_at;
		
		public CommandeBuilder setId_commande(int id_commande) {
			this.id_commande = id_commande;
			return this;
		}
		public CommandeBuilder setclient(Client client) {
			this.client = client;
			return this;
		}
		public CommandeBuilder setEtat(String etat) {
			this.etat = etat;
			return this;

		}
		public CommandeBuilder setcreated_at(Date created_at) {
			this.created_at = created_at;
			return this;

		}
		public CommandeBuilder setupdated_at(Date updated_at) {
			this.updated_at = updated_at;
			return this;
		}
		
		public Commande build() {
			return new Commande(this);
		}
	}
	
	
	
	
}
