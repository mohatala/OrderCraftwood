package craft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import craft.model.Commande;

@Repository("commandeRepository")
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

	@Query(value = "SELECT c.*, ca.* FROM commande c,commande_article ca WHERE c.id_commande=ca.id_commande and c.id_commande=?1",nativeQuery = true)
	List<Object[]> getInfosCommande(int id);
}
