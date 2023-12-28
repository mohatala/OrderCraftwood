package craft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import craft.model.Client;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
