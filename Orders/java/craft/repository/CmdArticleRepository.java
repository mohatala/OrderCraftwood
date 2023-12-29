package craft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import craft.model.CommandeArticle;

@Repository
public interface CmdArticleRepository extends JpaRepository<CommandeArticle, Integer>{

}
