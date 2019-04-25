package tk.chevalclinic.chevalclinic.bussines.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chevalclinic.chevalclinic.bussines.repository.PreviusVaccinationsRepository;
import tk.chevalclinic.chevalclinic.model.PreviusVaccinesEntity;

@Service
@Transactional(readOnly = true)
public class PreviusVaccinationsService {
	
	private final PreviusVaccinationsRepository previusRepository;
	
	public PreviusVaccinationsService(PreviusVaccinationsRepository previusRepository) {
		this.previusRepository = previusRepository;
	}
	
	@Transactional
	public PreviusVaccinesEntity create (PreviusVaccinesEntity previus) {
		return this.previusRepository.save(previus);
	}
	
	@Transactional
	public PreviusVaccinesEntity update (PreviusVaccinesEntity previus) {
		return this.previusRepository.save(previus);
	}
	
	public PreviusVaccinesEntity findById(long id) {
		return this.previusRepository.findById(id);
	}
	
	public List<PreviusVaccinesEntity> finAll(){
		return this.previusRepository.findAll();
	}

}
