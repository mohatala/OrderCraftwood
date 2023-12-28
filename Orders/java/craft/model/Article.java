package craft.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_article")
	private int id_article;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "categorie")
	private String categorie;
	@Column(name = "prix")
	private double prix;
	@Column(name = "stock")
	private int stock;
	
	public Article() {}
	
	public Article(ArticleBuilder builder) {
		this.id_article=builder.id_article;
		this.libelle = builder.libelle;
		this.categorie = builder.categorie;
		this.prix=builder.prix;
		this.stock = builder.stock;
	}
	

	public double getPrix() {
		return prix;
	}


	public int getId_article() {
		return id_article;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getCategorie() {
		return categorie;
	}

	public int getStock() {
		return stock;
	}

	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", libelle=" + libelle + ", categorie=" + categorie + ", stock="
				+ stock + "]";
	}
	
	public static class ArticleBuilder{
		private int id_article;
		private String libelle;
		private String categorie;
		private double prix;
		private int stock;
		
		public ArticleBuilder setId_article(int id_article) {
			this.id_article = id_article;
			return this;
		}
		public ArticleBuilder setLibelle(String libelle) {
			this.libelle = libelle;
			return this;

		}
		public ArticleBuilder setCategorie(String categorie) {
			this.categorie = categorie;
			return this;

		}
		public ArticleBuilder setPrix(double prix) {
			this.prix = prix;
			return this;

		}
		public ArticleBuilder setStock(int stock) {
			this.stock = stock;
			return this;

		}
		
		public Article build() {
			return new Article(this);
		}
	}

}
