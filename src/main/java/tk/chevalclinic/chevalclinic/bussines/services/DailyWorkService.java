package tk.chevalclinic.chevalclinic.bussines.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chevalclinic.chevalclinic.bussines.repository.DailyWorkRepository;
import tk.chevalclinic.chevalclinic.model.DailyWorkEntity;

@Service
@Transactional(readOnly = true)
public class DailyWorkService {

	private final DailyWorkRepository dailyWorkRepository;
	
	public DailyWorkService(DailyWorkRepository dailyWorkRepository) {
		this.dailyWorkRepository = dailyWorkRepository;
	}
	
	@Transactional
	public DailyWorkEntity create (DailyWorkEntity dailyWork) {
		return this.dailyWorkRepository.save(dailyWork);
	}
	
	@Transactional
	public DailyWorkEntity update (DailyWorkEntity dailyWork) {
		return this.dailyWorkRepository.save(dailyWork);
	}
	
	@Transactional
	public void delete (DailyWorkEntity dailyWork) {
		this.dailyWorkRepository.delete(dailyWork);
	}
	
	public DailyWorkEntity findById(long id) {
		return this.dailyWorkRepository.findById(id);
	}
	
	public List<DailyWorkEntity> findAll() {
		return this.dailyWorkRepository.findAll();
	}
	
	
}
