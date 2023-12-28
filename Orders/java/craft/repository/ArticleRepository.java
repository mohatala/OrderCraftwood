package craft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import craft.model.Article;

@Repository("articleRepository")
public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
