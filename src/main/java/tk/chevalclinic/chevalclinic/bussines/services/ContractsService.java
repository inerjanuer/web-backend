package tk.chevalclinic.chevalclinic.bussines.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chevalclinic.chevalclinic.bussines.repository.ContractsRepository;
import tk.chevalclinic.chevalclinic.model.ContractsEntity;

@Service
@Transactional(readOnly = true)
public class ContractsService {
	
	private final ContractsRepository contractsRepository;
	
	public ContractsService (ContractsRepository contractsRepository) {
		this.contractsRepository = contractsRepository;
	}
	
	@Transactional
	public ContractsEntity create (ContractsEntity contracts) {
		return this.contractsRepository.save(contracts);
	}
	
	@Transactional
	public ContractsEntity update (ContractsEntity contracts) {
		return this.contractsRepository.save(contracts);
	}
	
	@Transactional
	public void delete (ContractsEntity contracts) {
		this.contractsRepository.delete(contracts);
	}
	
	public ContractsEntity findById (long id) {
		return this.contractsRepository.findById(id);
	}
	
	public List<ContractsEntity> findAll() {
		return this.contractsRepository.findAll();
	}

}
