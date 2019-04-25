package tk.chevalclinic.chevalclinic.bussines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.chevalclinic.chevalclinic.model.PreviusVaccinesEntity;

public interface PreviusVaccinationsRepository extends JpaRepository<PreviusVaccinesEntity, Long> {

	public PreviusVaccinesEntity findById(long id);
}
