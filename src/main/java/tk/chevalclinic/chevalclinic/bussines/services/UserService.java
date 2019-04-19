package tk.chevalclinic.chevalclinic.bussines.services;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chevalclinic.chevalclinic.bussines.repository.UserRepository;
import tk.chevalclinic.chevalclinic.model.UserEntity;

@Service
@Transactional(readOnly = true)
public class UserService {

	private final UserRepository userRepository;
	
	public UserService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public UserEntity create (UserEntity horse) {
		return this.userRepository.save(horse);
	}
	
	@Transactional
	public UserEntity update (UserEntity horse) {
		return this.userRepository.save(horse);
	}
	
	@Transactional
	public void delete (UserEntity horse) {
		this.userRepository.delete(horse);
	}
	
	public UserEntity findById (int id) {
		return this.userRepository.findById(id);
	}
	
	public List<UserEntity> findAll() {
		return this.userRepository.findAll();	}
}