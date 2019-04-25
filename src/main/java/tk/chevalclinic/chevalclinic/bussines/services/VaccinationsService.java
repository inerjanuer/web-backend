package tk.chevalclinic.chevalclinic.bussines.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chevalclinic.chevalclinic.bussines.repository.VaccinationsRepository;
import tk.chevalclinic.chevalclinic.model.VaccinationsEntity;

@Service
@Transactional( readOnly = true )
public class VaccinationsService {
	
	private final VaccinationsRepository vaccinationsRepository;
	
	public VaccinationsService(VaccinationsRepository vaccinationsRepository) {
		this.vaccinationsRepository = vaccinationsRepository;
	}
	
	@Transactional
	public VaccinationsEntity create (VaccinationsEntity vaccinations) {
		return this.vaccinationsRepository.save(vaccinations);
	}
	
	@Transactional
	public VaccinationsEntity update (VaccinationsEntity vaccinations) {
		return this.vaccinationsRepository.save(vaccinations);
	}
	
	@Transactional
	public void delete (VaccinationsEntity vaccinations) {
		this.vaccinationsRepository.delete(vaccinations);
	}
	
	public VaccinationsEntity findById(long id) {
		return this.vaccinationsRepository.findById(id);
	}
	
	public List<VaccinationsEntity> findAll(){
		return this.vaccinationsRepository.findAll();
	}

}
