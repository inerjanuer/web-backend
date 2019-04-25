package tk.chevalclinic.chevalclinic.bussines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.chevalclinic.chevalclinic.model.VaccinationsEntity;

public interface VaccinationsRepository extends JpaRepository<VaccinationsEntity, Long>{

	public VaccinationsEntity findById(long id); 
	
}
