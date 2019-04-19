package tk.chevalclinic.chevalclinic.bussines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.chevalclinic.chevalclinic.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findById(long id);
}