package tk.chevalclinic.chevalclinic.bussines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.chevalclinic.chevalclinic.model.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long>{
	
	public ClientEntity findById(long id);	
}
