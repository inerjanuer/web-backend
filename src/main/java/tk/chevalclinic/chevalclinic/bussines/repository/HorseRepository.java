package tk.chevalclinic.chevalclinic.bussines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.chevalclinic.chevalclinic.model.HorseEntity;

public interface HorseRepository  extends JpaRepository<HorseEntity, Long>{

	public HorseEntity findById(long id);
}
