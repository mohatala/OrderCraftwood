package craft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import craft.model.Commande;
import craft.model.CommandeArticle;

@Repository
public interface CmdArticleRepository extends JpaRepository<CommandeArticle, Integer>{
	public List<CommandeArticle> findBycommande(Commande commande);
}
