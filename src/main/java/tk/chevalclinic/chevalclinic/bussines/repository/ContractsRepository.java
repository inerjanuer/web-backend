package tk.chevalclinic.chevalclinic.bussines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.chevalclinic.chevalclinic.model.ContractsEntity;

public interface ContractsRepository  extends JpaRepository<ContractsEntity, Long>{
	/*@Query("Select r from Reserva r where r.datecreated=:fecha")
	public List<ContractsEntity> find(@Param("fecha") Date fecha);*/
	public ContractsEntity findById(int id);
}
