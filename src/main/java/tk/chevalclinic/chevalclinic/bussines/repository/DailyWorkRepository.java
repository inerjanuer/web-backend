package tk.chevalclinic.chevalclinic.bussines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.chevalclinic.chevalclinic.model.DailyWorkEntity;

public interface DailyWorkRepository extends JpaRepository<DailyWorkEntity, Long>{
	
	public DailyWorkEntity findById(long id);

}
