package tk.chevalclinic.chevalclinic.bussines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.chevalclinic.chevalclinic.model.ContractsEntity;

public interface ContractsRepository  extends JpaRepository<ContractsEntity, Long>{
	
	public ContractsEntity findById(long id);
}
