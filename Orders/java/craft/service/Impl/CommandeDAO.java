package craft.service.Impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import craft.model.Article;
import craft.model.Commande;
import craft.service.I_Commande;
import craft.model.Etat;
import craft.repository.CommandeRepository;
@Service
public class CommandeDAO implements I_Commande{

    @Autowired
    private CommandeRepository commandeRepository;
    LocalDate date = LocalDate.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static Logger log = Logger.getLogger(CommandeDAO.class.getName());  

    @Override
    @Transactional
	public Commande ajouterCommande(Commande c,String listart) {
    	//Ajouter Une Commande

	            date.format(formatter);
                // Ajouter Commande
                Commande cmd=commandeRepository.saveAndFlush(c);
                        
    			JSONArray array = new JSONArray(listart);  
    			for(int i=0; i < array.length(); i++)   
    			{  
    			JSONObject object = array.getJSONObject(i); 
    			//CommandeArticle cmdart=new CommandeArticle.CommandeArticleBuilder().setId_article(object.getInt("id_article")).setId_commande(cmd.getId_commande()).setQty(object.getInt("qty")).build();
    			}
    		 log.debug("Commande Ajouter");
    		 
                return cmd;

	}
	@Override
	@Transactional
	public Commande afficherCommandeAvecId(int id){
		//Afficher une commande avec id commande
		Commande cmd=commandeRepository.getOne(id);
				log.debug("Afficher Commande  id"+id);
		return cmd; 
	}
	@Override
	@Transactional
	public List afficherCommandes(){
		//afficher tous les commandes
		List commandesList=commandeRepository.findAll();
			log.debug("afficher list Commandes");

		return commandesList; 
	}
	
	@Override
	@Transactional
	public ArrayList<String> afficherInfosCommande(int id){
		//afficher les informations des commandes
		ArrayList<String> commandesList=new ArrayList<>();
		List<Object[]> li=commandeRepository.getInfosCommande(id);
		
		for (Object o[] : li) {
		    Commande c = (Commande) o[0];
		    //CommandeArticle ca = (CommandeArticle) o[1];

		    //all the classes: Course, Lesson, Progress and User have the toString() overridden with the database ID;    
		    //System.out.printf("\ncommande: %s \n commande article: %s",c,ca);
		}
			/*String ob=null;
			while (st.next()) {
			ob=st.getInt(1)+","+st.getInt(2)+","+ st.getInt(3)+","+ st.getInt(4);
			commandesList.add(ob);
			}*/
			log.debug("Afficher les infos commande");
	
		return commandesList; 
	}
		
	@Override
	@Transactional
	public Commande modifieretat(int id,String etat) {
		//modifier l'etat de la commande
		 // Modifier Etat
		Commande cmd=this.afficherCommandeAvecId(id);
		ArticleDAO artdao =new ArticleDAO();
		ArrayList<String> listart=this.afficherInfosCommande(id);
		//System.out.print(cmd.getEtat());
		Etat enumEtat = null;
		if(cmd.getEtat().equals(enumEtat.EnCours.name().toString())|| cmd.getEtat().equals(enumEtat.EnAttente.name().toString())) {
			if(etat.equals(enumEtat.Complete.name().toString())) {
				for(String std:listart) {
					String[] s=std.split(",");
					Article art=artdao.afficherArticleAvecId(Integer.parseInt(s[2]));
					int qty=art.getStock()-Integer.parseInt(s[3]);
					art=new Article.ArticleBuilder().setId_article(art.getId_article()).setLibelle(art.getLibelle()).setCategorie(art.getCategorie()).setPrix(art.getPrix()).setStock(qty).build();
					//System.out.print(art);
					artdao.modifierArticle(art);
				}
			}
		}
		if(cmd.getEtat().equals(enumEtat.Complete.name().toString())) {
			if(etat.equals(enumEtat.Annuler.name().toString())) {
				for(String std:listart) {
					String[] s=std.split(",");
					Article art=artdao.afficherArticleAvecId(Integer.parseInt(s[2]));
					int qty=art.getStock()+Integer.parseInt(s[3]);
					art=new Article.ArticleBuilder().setId_article(art.getId_article()).setLibelle(art.getLibelle()).setCategorie(art.getCategorie()).setPrix(art.getPrix()).setStock(qty).build();
					//System.out.print(art);
					artdao.modifierArticle(art);
				}
			}
		}
        date.format(formatter);
		 /*String insertQuery = "UPDATE commande set etat='"+etat+"',date_modification='"+date+"' WHERE id_commande="+id;
		 int check= sqloperation.ajouterSql(insertQuery,null);
		 if(check>0) {
			 log.debug("Etat commande modifier");
			   return this.afficherCommandeAvecId(id);
		   }*/
		  return null;
	}
	
	@Override
	@Transactional
	public boolean supprimeCommandes(int id) {
		//Delete from Table Commande Article
        /*String query = "DELETE FROM commande_article WHERE id_commande = "+id;
		int check= sqloperation.ajouterSql(query,null);
   	   if(check>0) {
   		   //Delete from Table Commande
		   String query1 = "DELETE FROM commande WHERE id_commande = "+id;
		   int check1= sqloperation.ajouterSql(query1,null);
		   if(check1>0) {
			   log.debug("Commande Supprimer");
			   return true;
		   }
   	   }*/
		return false;
	}
	
}
