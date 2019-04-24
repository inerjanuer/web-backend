package tk.chevalclinic.chevalclinic.bussines.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chevalclinic.chevalclinic.bussines.repository.TypeStatusRepository;
import tk.chevalclinic.chevalclinic.model.TypeStatusEntity;

@Service
@Transactional( readOnly = true )
public class TypeStatusService {
	private final TypeStatusRepository typeStatusRepository;
	
	public TypeStatusService(TypeStatusRepository typeStatusRepository) {
		this.typeStatusRepository = typeStatusRepository;
	}
	
	public TypeStatusEntity findById (long id) {
		return this.typeStatusRepository.findById(id);
	}
	
	public List<TypeStatusEntity> findAll() {
		return this.typeStatusRepository.findAll();
	}

}
