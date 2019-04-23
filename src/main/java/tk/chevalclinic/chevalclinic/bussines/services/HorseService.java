package tk.chevalclinic.chevalclinic.bussines.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chevalclinic.chevalclinic.bussines.repository.HorseRepository;
import tk.chevalclinic.chevalclinic.model.HorseEntity;

@Service
@Transactional(readOnly = true)
public class HorseService {

	private final HorseRepository horseRepository;
	
	public HorseService (HorseRepository horseRepository) {
		this.horseRepository = horseRepository;
	}
	
	@Transactional
	public HorseEntity create (HorseEntity horse) {
		return this.horseRepository.save(horse);
	}
	
	@Transactional
	public HorseEntity update (HorseEntity horse) {
		return this.horseRepository.save(horse);
	}
	
	@Transactional
	public void delete (HorseEntity horse) {
		this.horseRepository.delete(horse);
	}
	
	public HorseEntity findById (long id) {
		return this.horseRepository.findById(id);
	}
	
	public List<HorseEntity> findAll() {
		return this.horseRepository.findAll();	}
}
