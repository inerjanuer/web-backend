package tk.chevalclinic.chevalclinic.bussines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.chevalclinic.chevalclinic.model.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long>{
	
	//public List<ClientEntity> findByNick(String nick);
	
	public ClientEntity findById(long id);	
}
